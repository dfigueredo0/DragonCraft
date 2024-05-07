package com.elysiumgames.dragoncraft.network;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.Objects;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldVariables {
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        DragonCraft.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer,
                SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
    }

    @Mod.EventBusSubscriber
    public static class EventBusVariableHandlers {
        @SubscribeEvent
        public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
            if (!event.getEntity().level().isClientSide()) {
                SavedData mapData = MapVariables.get(event.getEntity().level());
                SavedData worldData = LevelVariables.get(event.getEntity().level());
                if (mapData != null)
                    DragonCraft.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapData));
                if (worldData != null)
                    DragonCraft.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worldData));
            }
        }
    }

    public static class LevelVariables extends SavedData {
        public static final String DATA_NAME = "dragoncraft_levelvars";
        static LevelVariables clientSide = new LevelVariables();

        public static LevelVariables load(CompoundTag tag) {
            LevelVariables data = new LevelVariables();
            data.read(tag);
            return data;
        }

        public void read(CompoundTag tag) {

        }

        @Override
        public CompoundTag save(CompoundTag compoundTag) {
            return compoundTag;
        }

        public void syncData(LevelAccessor level) {
            if (level instanceof Level world) {
                if (!world.isClientSide()) {
                    Objects.requireNonNull(world);
                    DragonCraft.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world::dimension), new SavedDataSyncMessage(1, this));
                }
            }
        }

        public static LevelVariables get(LevelAccessor world) {
            if (world instanceof ServerLevel level) {
                return level.getDataStorage().computeIfAbsent(LevelVariables::load, LevelVariables::new, "dragoncraft_levelvars");
            }
            return clientSide;
        }
    }

    public static class MapVariables extends SavedData {
        public static final String DATA_NAME = "dragoncraft_mapvars";
        static MapVariables clientSide = new MapVariables();


        public boolean dragonBallSpawned = false;
        public boolean dragonBall1Spawned = false;
        public boolean dragonBall2Spawned = false;
        public boolean dragonBall3Spawned = false;
        public boolean dragonBall4Spawned = false;
        public boolean dragonBall5Spawned = false;
        public boolean dragonBall6Spawned = false;
        public boolean shenronSpawned = false;

        public static MapVariables load(CompoundTag tag) {
            MapVariables data = new MapVariables();
            data.read(tag);
            return data;
        }

        public void read(CompoundTag tag) {
            this.dragonBallSpawned = tag.getBoolean("dragonBallSpawned");
            this.dragonBall1Spawned = tag.getBoolean("dragonBall1Spawned");
            this.dragonBall2Spawned = tag.getBoolean("dragonBall2Spawned");
            this.dragonBall3Spawned = tag.getBoolean("dragonBall3Spawned");
            this.dragonBall4Spawned = tag.getBoolean("dragonBall4Spawned");
            this.dragonBall5Spawned = tag.getBoolean("dragonBall5Spawned");
            this.dragonBall6Spawned = tag.getBoolean("dragonBall6Spawned");
            this.shenronSpawned = tag.getBoolean("shenronSpawned");
        }

        @Override
        public CompoundTag save(CompoundTag compoundTag) {
            compoundTag.putBoolean("dragonBallSpawned", this.dragonBallSpawned);
            compoundTag.putBoolean("dragonBall1Spawned", this.dragonBall1Spawned);
            compoundTag.putBoolean("dragonBall2Spawned", this.dragonBall2Spawned);
            compoundTag.putBoolean("dragonBall3Spawned", this.dragonBall3Spawned);
            compoundTag.putBoolean("dragonBall4Spawned", this.dragonBall4Spawned);
            compoundTag.putBoolean("dragonBall5Spawned", this.dragonBall5Spawned);
            compoundTag.putBoolean("dragonBall6Spawned", this.dragonBall6Spawned);
            compoundTag.putBoolean("shenronSpawned", this.shenronSpawned);
            return compoundTag;
        }

        public void syncData(LevelAccessor world) {
            if (world instanceof Level level) {
                if (!level.isClientSide()) {
                    DragonCraft.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
                }
            }
        }

        public static MapVariables get(LevelAccessor world) {
            if (world instanceof ServerLevelAccessor accessor)
                return accessor.getServer().overworld().getDataStorage().computeIfAbsent(MapVariables::load, MapVariables::new,"dragoncraft_mapvars");
            return clientSide;
        }
    }

    public static class SavedDataSyncMessage {
        public int type;
        public SavedData data;

        public SavedDataSyncMessage(FriendlyByteBuf pBuffer) {
            this.type = pBuffer.readInt();
            this.data = this.type == 0 ? new MapVariables() : new LevelVariables();
            SavedData savedData = this.data;
            if (savedData instanceof MapVariables) {
                MapVariables mapVariables = (MapVariables) savedData;
                mapVariables.read(pBuffer.readNbt());
            } else {
                savedData = this.data;
                if (savedData instanceof LevelVariables) {
                    LevelVariables levelVariables = (LevelVariables) savedData;
                    levelVariables.read(pBuffer.readNbt());
                }
            }
        }

        public SavedDataSyncMessage(int type, SavedData data) {
            this.type = type;
            this.data = data;
        }

        public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf pBuffer) {
            pBuffer.writeInt(message.type);
            pBuffer.writeNbt(message.data.save(new CompoundTag()));
        }

        public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> supplier) {
            NetworkEvent.Context context = supplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    if (message.type == 0) {
                        MapVariables.clientSide = (MapVariables) message.data;
                    } else {
                        LevelVariables.clientSide = (LevelVariables) message.data;
                    }
                }
            });
            context.setPacketHandled(true);
        }
    }
}
