package com.elysiumgames.dragoncraft.network.packet;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleC2SPacket {
    int type;
    int lastPressedTime;
    public ExampleC2SPacket(int type, int lastPressedTime) {
        this.type = type;
        this.lastPressedTime = lastPressedTime;
    }

    public ExampleC2SPacket(FriendlyByteBuf pBuffer) {
        this.type = pBuffer.readInt();
        this.lastPressedTime = pBuffer.readInt();
    }

    public static void toBytes(ExampleC2SPacket packet, FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(packet.type);
        pBuffer.writeInt(packet.lastPressedTime);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // ON SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
        });
        context.setPacketHandled(true);
    }

    public static void press(Player player, int type, int lastPressedTime) {

    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        DragonCraft.addNetworkMessage(ExampleC2SPacket.class, ExampleC2SPacket::toBytes, ExampleC2SPacket::new, ExampleC2SPacket::handle);
    }
}
