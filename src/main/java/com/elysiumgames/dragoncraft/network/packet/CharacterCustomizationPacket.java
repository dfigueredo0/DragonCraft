package com.elysiumgames.dragoncraft.network.packet;

import com.elysiumgames.dragoncraft.DragonCraft;
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
public class CharacterCustomizationPacket {
    private final int buttonId;
    private final int x, y, z;

    public CharacterCustomizationPacket(FriendlyByteBuf pBuffer) {
        this.buttonId = pBuffer.readInt();
        this.x = pBuffer.readInt();
        this.y = pBuffer.readInt();
        this.z = pBuffer.readInt();
    }

    public CharacterCustomizationPacket(int buttonId, int x, int y, int z) {
        this.buttonId = buttonId;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void toBytes(CharacterCustomizationPacket packet, FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(packet.buttonId);
        pBuffer.writeInt(packet.x);
        pBuffer.writeInt(packet.y);
        pBuffer.writeInt(packet.z);
    }

    public static void handle(CharacterCustomizationPacket packet, Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
           ServerPlayer serverPlayer = context.getSender();
           int buttonId = packet.buttonId;
           int x = packet.x;
           int y = packet.y;
           int z = packet.z;

            assert serverPlayer != null;
            handleButtonAction(serverPlayer, buttonId, x, y, z);
        });
    }

    public static void handleButtonAction(ServerPlayer player, int buttonId, int x, int y, int z) {
        Level level = player.level();

        if (!level.isLoaded(new BlockPos(x, y, z)))
            return;
        if (buttonId == 0) {

        }
        if (buttonId == 1) {

        }
        if (buttonId == 2) {

        }
        if (buttonId == 3) {

        }
        if (buttonId == 4) {

        }
        if (buttonId == 5) {

        }
        if (buttonId == 6) {

        }
        if (buttonId == 7) {

        }
        if (buttonId == 8) {

        }
        if (buttonId == 9) {

        }
        if (buttonId == 10) {

        }
        if (buttonId == 11) {

        }
        if (buttonId == 12) {

        }
        if (buttonId == 13) {

        }
        if (buttonId == 14) {

        }
        if (buttonId == 15) {

        }
        if (buttonId == 16) {

        }
        if (buttonId == 17) {

        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        DragonCraft.addNetworkMessage(CharacterCustomizationPacket.class, CharacterCustomizationPacket::toBytes, CharacterCustomizationPacket::new, CharacterCustomizationPacket::handle);
    }
}
