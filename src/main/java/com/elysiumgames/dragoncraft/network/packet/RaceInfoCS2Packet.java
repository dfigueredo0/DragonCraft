package com.elysiumgames.dragoncraft.network.packet;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.client.gui.screens.RaceInfoScreen;
import com.elysiumgames.dragoncraft.network.ClientHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RaceInfoCS2Packet {
    private final int x, y, z;

    public RaceInfoCS2Packet(FriendlyByteBuf pBuffer) {
        this.x = pBuffer.readInt();
        this.y = pBuffer.readInt();
        this.z = pBuffer.readInt();
    }

    public RaceInfoCS2Packet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void toBytes(RaceInfoCS2Packet packet, FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(packet.x);
        pBuffer.writeInt(packet.y);
        pBuffer.writeInt(packet.z);
    }

    public static void handle(RaceInfoCS2Packet packet, Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer serverPlayer = context.getSender();
            int x = packet.x;
            int y = packet.y;
            int z = packet.z;

            assert serverPlayer != null;
            handleButtonAction(serverPlayer, x, y, z);
        });
    }

    public static void handleButtonAction(Player player, int x, int y, int z) {
        Level level = player.level();

        if (level.isLoaded(new BlockPos(x, y, z)))
            return;
        if (player instanceof ServerPlayer) {
            ClientHooks.openScreen(new RaceInfoScreen(new BlockPos(x, y, z)));
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        DragonCraft.addNetworkMessage(RaceInfoCS2Packet.class, RaceInfoCS2Packet::toBytes, RaceInfoCS2Packet::new, RaceInfoCS2Packet::handle);
    }
}
