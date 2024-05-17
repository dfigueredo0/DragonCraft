package com.elysiumgames.dragoncraft.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public class ClientHooks {
    public static void openScreen(Screen screen) {
        Minecraft.getInstance().setScreen(screen);
    }
}
