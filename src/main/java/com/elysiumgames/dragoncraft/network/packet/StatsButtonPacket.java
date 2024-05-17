package com.elysiumgames.dragoncraft.network.packet;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import com.elysiumgames.dragoncraft.network.handlers.StatusPointsHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StatsButtonPacket {
    private final int buttonID;

    public StatsButtonPacket(FriendlyByteBuf pBuffer) {
        this.buttonID = pBuffer.readInt();
    }

    public StatsButtonPacket(int buttonID) {
        this.buttonID = buttonID;
    }

    public static void toBytes(StatsButtonPacket packet, FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(packet.buttonID);
    }

    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        DragonCraft.addNetworkMessage(StatsButtonPacket.class, StatsButtonPacket::toBytes, StatsButtonPacket::new, StatsButtonPacket::handle);
    }

    public static void handle(StatsButtonPacket packet, Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // ON SERVER
            ServerPlayer player = context.getSender();
            int buttonID = packet.buttonID;
            assert player != null;
            handleButtonAction(player, buttonID);
        });
        context.setPacketHandled(true);
    }

    public static void handleButtonAction(Player player, int buttonID) {
        assert player != null;
        PlayerStatusVariables.PlayerVariables playerVariables = player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables());
        switch (buttonID) {
            case 0:
                if (hasEnoughStatPoints(player)) {
                    double newMaxHealth = playerVariables.maxHealth + 20.0D;
                    double xp = playerVariables.xp + 1.0D;
                    double statPoints = playerVariables.statusPoints - playerVariables.neededStatPoints;
                    player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.maxHealth = newMaxHealth;
                        capability.xp = xp;
                        capability.statusPoints = statPoints;
                        capability.syncPlayerVariables(player);
                    });
                }
                StatusPointsHandler.increaseNeededPoints(player);
                break;
            case 1:
                if (hasEnoughStatPoints(player)) {
                    double newMaxKi = playerVariables.maxKi + 7.5D;
                    double xp = playerVariables.xp + 1.0D;
                    double statPoints = playerVariables.statusPoints - playerVariables.neededStatPoints;
                    player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.maxKi = newMaxKi;
                        capability.xp = xp;
                        capability.statusPoints = statPoints;
                        capability.syncPlayerVariables(player);
                    });
                }
                StatusPointsHandler.increaseNeededPoints(player);
                break;
            case 2:
                if (hasEnoughStatPoints(player)) {
                    double newMaxStamina = playerVariables.maxStamina + 4.5D;
                    double xp = playerVariables.xp + 1.0D;
                    double statPoints = playerVariables.statusPoints - playerVariables.neededStatPoints;
                    player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.maxKi = newMaxStamina;
                        capability.xp = xp;
                        capability.statusPoints = statPoints;
                        capability.syncPlayerVariables(player);
                    });
                }
                StatusPointsHandler.increaseNeededPoints(player);
                break;
            case 3:
                if (hasEnoughStatPoints(player)) {
                    double newStrength = playerVariables.strength + 5.5D;
                    double xp = playerVariables.xp + 1.0D;
                    double statPoints = playerVariables.statusPoints - playerVariables.neededStatPoints;
                    player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.strength = newStrength;
                        capability.xp = xp;
                        capability.statusPoints = statPoints;
                        capability.syncPlayerVariables(player);
                    });
                }
                StatusPointsHandler.increaseNeededPoints(player);
                break;
            case 4:
                if (hasEnoughStatPoints(player)) {
                    double newDexterity = playerVariables.speed + 12.5D; //TODO: Create dex variable
                    double xp = playerVariables.xp + 1.0D;
                    double statPoints = playerVariables.statusPoints - playerVariables.neededStatPoints;
                    player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.speed = newDexterity;
                        capability.xp = xp;
                        capability.statusPoints = statPoints;
                        capability.syncPlayerVariables(player);
                    });
                }
                StatusPointsHandler.increaseNeededPoints(player);
                break;
            case 5:
                if (hasEnoughStatPoints(player)) {
                    double newKiPower = playerVariables.kiPower + 12.5D;
                    double xp = playerVariables.xp + 1.0D;
                    double statPoints = playerVariables.statusPoints - playerVariables.neededStatPoints;
                    player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.kiPower = newKiPower;
                        capability.xp = xp;
                        capability.statusPoints = statPoints;
                        capability.syncPlayerVariables(player);
                    });
                }
                StatusPointsHandler.increaseNeededPoints(player);
                break;
        }
    }

    private static boolean hasEnoughStatPoints(Player player) {
        return player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints
                >= player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).neededStatPoints;
    }
}
