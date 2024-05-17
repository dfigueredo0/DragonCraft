package com.elysiumgames.dragoncraft.network.packet;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltFunctionC2SPacket {
    int type;
    int lastPressedTime;

    public AltFunctionC2SPacket(int type, int lastPressedTime) {
        this.type = type;
        this.lastPressedTime = lastPressedTime;
    }

    public AltFunctionC2SPacket(FriendlyByteBuf pBuffer) {
        this.type = pBuffer.readInt();
        this.lastPressedTime = pBuffer.readInt();
    }

    public static void toByte(AltFunctionC2SPacket message, FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(message.type);
        pBuffer.writeInt(message.lastPressedTime);
    }

    public static void handle(AltFunctionC2SPacket message, Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            if (message.type == 0) {
                assert player != null;
                double selectedSlot =  player.getInventory().selected;
                player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.altFunction = true;
                    capability.selectedSlot = selectedSlot;
                    capability.syncPlayerVariables(player);
                });
                if (message.type == 1) {
                    player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.altFunction = false;
                        capability.syncPlayerVariables(player);
                    });
                }
            }
        });
        context.setPacketHandled(true);
    }

    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        DragonCraft.addNetworkMessage(AltFunctionC2SPacket.class, AltFunctionC2SPacket::toByte, AltFunctionC2SPacket::new, AltFunctionC2SPacket::handle);
    }
}
