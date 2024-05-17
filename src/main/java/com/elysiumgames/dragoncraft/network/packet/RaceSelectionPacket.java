package com.elysiumgames.dragoncraft.network.packet;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.client.gui.screens.CharacterCustomizationScreen;
import com.elysiumgames.dragoncraft.client.gui.screens.RaceInfoScreen;
import com.elysiumgames.dragoncraft.client.gui.screens.WelcomeScreen;
import com.elysiumgames.dragoncraft.network.ClientHooks;
import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import com.elysiumgames.dragoncraft.utils.Constants;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RaceSelectionPacket {
    private final String race;
    private final int buttonId;
    private final int x, y, z;

    public RaceSelectionPacket(FriendlyByteBuf pBuffer) {
        this.race = pBuffer.readUtf();
        this.buttonId = pBuffer.readInt();
        this.x = pBuffer.readInt();
        this.y = pBuffer.readInt();
        this.z = pBuffer.readInt();
    }

    public RaceSelectionPacket(String race, int buttonID, int x, int y, int z) {
        this.race = race;
        this.buttonId = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void toBytes(RaceSelectionPacket packet, FriendlyByteBuf pBuffer) {
        pBuffer.writeUtf(packet.race);
        pBuffer.writeInt(packet.buttonId);
        pBuffer.writeInt(packet.x);
        pBuffer.writeInt(packet.y);
        pBuffer.writeInt(packet.z);
    }

    public static void handle(RaceSelectionPacket packet, Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer serverPlayer = context.getSender();
            String race = packet.race;
            int buttonId = packet.buttonId;
            int x = packet.x;
            int y = packet.y;
            int z = packet.z;

            assert serverPlayer != null;
            handleButtonAction(serverPlayer, race, buttonId, x, y, z);
        });
        context.setPacketHandled(true);
    }

    public static void handleButtonAction(ServerPlayer player, String race, int buttonId, int x, int y, int z) {
        Level level = player.level();

        if (level.isLoaded(new BlockPos(x, y, z)))
            return;
        if (race.equals(Constants.Race.HUMAN.getRace())) {
            if (buttonId == 3) {
                String playerRace = "Human";
                String bodyType = "Humanoid";
                player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.race = playerRace;
                    capability.bodyType = bodyType;
                    capability.syncPlayerVariables(player);
                });
            }
           if (buttonId == 11) {
               ClientHooks.openScreen(new RaceInfoScreen(new BlockPos(x, y, z)));
           }
        } else if (race.equals(Constants.Race.SAIYAN.getRace())) {
            if (buttonId == 0) {
                String playerRace = "Saiyan";
                String bodyType = "Humanoid";
                player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.race = playerRace;
                    capability.bodyType = bodyType;
                    capability.syncPlayerVariables(player);
                });
            }
           if (buttonId == 8) {
               ClientHooks.openScreen(new RaceInfoScreen(new BlockPos(x, y, z)));
           }
        } else if (race.equals(Constants.Race.HALF_SAIYAN.getRace())) {
            if (buttonId == 7) {
                String playerRace = "Half_Saiyan";
                String bodyType = "Humanoid";
                player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.race = playerRace;
                    capability.bodyType = bodyType;
                    capability.syncPlayerVariables(player);
                });
            }
            if (buttonId == 13) {
                ClientHooks.openScreen(new RaceInfoScreen(new BlockPos(x, y, z)));
            }

        } else if (race.equals(Constants.Race.NAMEKIAN.getRace())) {
            if (buttonId == 1) {
                String playerRace = "Namekian";
                String bodyType = "Namekian";
                player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.race = playerRace;
                    capability.bodyType = bodyType;
                    capability.syncPlayerVariables(player);
                });
            }
           if (buttonId == 9) {
               ClientHooks.openScreen(new RaceInfoScreen(new BlockPos(x, y, z)));
           }
        } else if (race.equals(Constants.Race.FROST_DEMON.getRace())) {
            if (buttonId == 2) {
                String playerRace = "Frost_Demon";
                String bodyType = "Frost_Demon";
                player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.race = playerRace;
                    capability.bodyType = bodyType;
                    capability.syncPlayerVariables(player);
                });
            }
            if (buttonId == 10) {
                ClientHooks.openScreen(new RaceInfoScreen(new BlockPos(x, y, z)));
            }
        } else if (race.equals(Constants.Race.MAJIN.getRace())) {
            if (buttonId == 4) {
                String playerRace = "Majin";
                String bodyType = "Majin";
                player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.race = playerRace;
                    capability.bodyType = bodyType;
                    capability.syncPlayerVariables(player);
                });
            }
           if (buttonId == 12) {
               ClientHooks.openScreen(new RaceInfoScreen(new BlockPos(x, y, z)));
           }
        }
        if (buttonId == 5) {
            ClientHooks.openScreen(new CharacterCustomizationScreen(new BlockPos(x, y, z)));
        }
        if (buttonId == 6) {
            ClientHooks.openScreen(new WelcomeScreen(new BlockPos(x, y, z)));
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        DragonCraft.addNetworkMessage(RaceSelectionPacket.class, RaceSelectionPacket::toBytes, RaceSelectionPacket::new, RaceSelectionPacket::handle);
    }
}
