package com.elysiumgames.dragoncraft.client.gui.screens;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class WelcomeScreen extends Screen {
    private static final Component TITLE = Component.translatable("gui." + DragonCraft.MOD_ID + ".welcome_screen");
    private static final ResourceLocation TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/welcome_gui.png");
    private final int imageWidth, imageHeight;
    private Player player;
    private int leftPos, topPos;

    public WelcomeScreen(BlockPos pBlockPos) {
        super(TITLE);
        pBlockPos = player.blockPosition();
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        assert this.minecraft != null;
        this.player = this.minecraft.player;
        this.minecraft.pauseGame(false);
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        pGuiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }
}
