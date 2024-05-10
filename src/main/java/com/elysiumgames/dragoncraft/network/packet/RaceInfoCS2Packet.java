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


public class RaceInfoCS2Packet {
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class FrostDemonInfoButton {
        int type;
        int lastPressedTime;
        public FrostDemonInfoButton(int type, int lastPressedTime) {
            this.type = type;
            this.lastPressedTime = lastPressedTime;
        }

        public FrostDemonInfoButton(FriendlyByteBuf pBuffer) {
            this.type = pBuffer.readInt();
            this.lastPressedTime = pBuffer.readInt();
        }

        public static void toBytes(FrostDemonInfoButton packet, FriendlyByteBuf pBuffer) {
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
            DragonCraft.addNetworkMessage(FrostDemonInfoButton.class, FrostDemonInfoButton::toBytes, FrostDemonInfoButton::new, FrostDemonInfoButton::handle);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class SaiyanInfoButton {
        int type;
        int lastPressedTime;
        public SaiyanInfoButton(int type, int lastPressedTime) {
            this.type = type;
            this.lastPressedTime = lastPressedTime;
        }

        public SaiyanInfoButton(FriendlyByteBuf pBuffer) {
            this.type = pBuffer.readInt();
            this.lastPressedTime = pBuffer.readInt();
        }

        public static void toBytes(SaiyanInfoButton packet, FriendlyByteBuf pBuffer) {
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
            DragonCraft.addNetworkMessage(SaiyanInfoButton.class, SaiyanInfoButton::toBytes, SaiyanInfoButton::new, SaiyanInfoButton::handle);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class HalfSaiyanInfoButton {
        int type;
        int lastPressedTime;
        public HalfSaiyanInfoButton(int type, int lastPressedTime) {
            this.type = type;
            this.lastPressedTime = lastPressedTime;
        }

        public HalfSaiyanInfoButton(FriendlyByteBuf pBuffer) {
            this.type = pBuffer.readInt();
            this.lastPressedTime = pBuffer.readInt();
        }

        public static void toBytes(HalfSaiyanInfoButton packet, FriendlyByteBuf pBuffer) {
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
            DragonCraft.addNetworkMessage(HalfSaiyanInfoButton.class, HalfSaiyanInfoButton::toBytes, HalfSaiyanInfoButton::new, HalfSaiyanInfoButton::handle);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class HumanInfoButton {
        int type;
        int lastPressedTime;
        public HumanInfoButton(int type, int lastPressedTime) {
            this.type = type;
            this.lastPressedTime = lastPressedTime;
        }

        public HumanInfoButton(FriendlyByteBuf pBuffer) {
            this.type = pBuffer.readInt();
            this.lastPressedTime = pBuffer.readInt();
        }

        public static void toBytes(HumanInfoButton packet, FriendlyByteBuf pBuffer) {
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
            DragonCraft.addNetworkMessage(HumanInfoButton.class, HumanInfoButton::toBytes, HumanInfoButton::new, HumanInfoButton::handle);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class NamekianInfoButton {
        int type;
        int lastPressedTime;
        public NamekianInfoButton(int type, int lastPressedTime) {
            this.type = type;
            this.lastPressedTime = lastPressedTime;
        }

        public NamekianInfoButton(FriendlyByteBuf pBuffer) {
            this.type = pBuffer.readInt();
            this.lastPressedTime = pBuffer.readInt();
        }

        public static void toBytes(NamekianInfoButton packet, FriendlyByteBuf pBuffer) {
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
            DragonCraft.addNetworkMessage(NamekianInfoButton.class, NamekianInfoButton::toBytes, NamekianInfoButton::new, NamekianInfoButton::handle);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class MajinInfoButton {
        int type;
        int lastPressedTime;
        public MajinInfoButton(int type, int lastPressedTime) {
            this.type = type;
            this.lastPressedTime = lastPressedTime;
        }

        public MajinInfoButton(FriendlyByteBuf pBuffer) {
            this.type = pBuffer.readInt();
            this.lastPressedTime = pBuffer.readInt();
        }

        public static void toBytes(MajinInfoButton packet, FriendlyByteBuf pBuffer) {
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
            DragonCraft.addNetworkMessage(MajinInfoButton.class, MajinInfoButton::toBytes, MajinInfoButton::new, MajinInfoButton::handle);
        }
    }
}