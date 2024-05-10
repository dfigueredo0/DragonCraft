package com.elysiumgames.dragoncraft.client.gui.screens;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.inventory.StatisticsMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class StatisticsMenuScreen extends AbstractContainerScreen<StatisticsMenu> {
    private static final HashMap<String, Object> GUI_STATE = StatisticsMenu.GUI_STATE;
    private static final ResourceLocation TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/statistics_screen.png");
    private final Level level;
    private final int x, y, z;
    private final Player player;
    protected ImageButton healthButton;
    protected ImageButton kiButton;
    protected ImageButton staminaButton;
    protected ImageButton strengthButton;
    protected ImageButton dexterityButton;
    protected ImageButton kiPowerButton;

    public StatisticsMenuScreen(StatisticsMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.level = pMenu.level;
        this.x = pMenu.x;
        this.y = pMenu.y;
        this.z = pMenu.z;
        this.player = pMenu.player;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }
}
