package com.elysiumgames.dragoncraft.event;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.client.ModKeyMappings;
import com.elysiumgames.dragoncraft.network.ClientHooks;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DragonCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientForgeBusEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft minecraft = Minecraft.getInstance();

        assert minecraft.player != null;
        if (ModKeyMappings.OPEN_STATS_KEY.consumeClick()) {
            ClientHooks.openStatScreen();
        }
    }
}
