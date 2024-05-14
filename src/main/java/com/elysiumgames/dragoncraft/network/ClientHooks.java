package com.elysiumgames.dragoncraft.network;

import com.elysiumgames.dragoncraft.client.gui.screens.StatisticsMenuScreen;
import com.elysiumgames.dragoncraft.client.gui.screens.WishScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;

public class ClientHooks {
    public static void openScreen(BlockPos pBlockPos) {
        Minecraft.getInstance().setScreen(new WishScreen(pBlockPos));
    }

    public static void openStatScreen() {
        Minecraft.getInstance().setScreen(new StatisticsMenuScreen());
    }
}
