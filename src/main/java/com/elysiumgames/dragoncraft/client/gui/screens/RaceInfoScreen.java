package com.elysiumgames.dragoncraft.client.gui.screens;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.utils.Constants;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import static com.elysiumgames.dragoncraft.utils.Constants.Race.*;

public class RaceInfoScreen extends Screen {
    private static final Component TITLE = Component.translatable("gui." + DragonCraft.MOD_ID + ".race_info_screen");
    private static final ResourceLocation TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/info_card_gui.png");
    private final int imageWidth, imageHeight;
    private Player player;
    private int leftPos, topPos;

    public RaceInfoScreen(BlockPos blockPos) {
        super(TITLE);
        blockPos = player.blockPosition();
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
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        pGuiGraphics.blit(TEXTURE, this.leftPos - 111, this.topPos - 75, 0 ,0, this.imageWidth, this.imageHeight);

        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        renderLabels(pGuiGraphics, pMouseX, pMouseY, HUMAN);
        renderLabels(pGuiGraphics, pMouseX, pMouseY, SAIYAN);
        renderLabels(pGuiGraphics, pMouseX, pMouseY, HALF_SAIYAN);
        renderLabels(pGuiGraphics, pMouseX, pMouseY, NAMEKIAN);
        renderLabels(pGuiGraphics, pMouseX, pMouseY, FROST_DEMON);
        renderLabels(pGuiGraphics, pMouseX, pMouseY, MAJIN);
    }

    private void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, Constants.Race race) {
        switch (race) {
            case HUMAN:
                drawStats(pGuiGraphics, new Attributes("Human", "380", "80", "20", "10", "25"), 0x2CBAA8);
                break;
            case SAIYAN:
                drawStats(pGuiGraphics, new Attributes("Saiyan", "200", "120", "60", "30", "75"), 0xFFAA00);
                break;
            case HALF_SAIYAN:
                drawStats(pGuiGraphics, new Attributes("Half Saiyan", "290", "150", "25", "15", "80"), 0xDEB12D);
                break;
            case NAMEKIAN:
                drawStats(pGuiGraphics, new Attributes("Namekian", "600", "120", "10", "10", "30"), 0x00AA00);
                break;
            case FROST_DEMON:
                drawStats(pGuiGraphics, new Attributes("Frost Demon", "400", "500", "20", "10", "100"), 0xAA0000);
                break;
            case MAJIN:
                //TODO: Change Values
                drawStats(pGuiGraphics, new Attributes("Majin", "380", "80", "20", "10", "25"), 0xFF55FF);
                break;
        }
    }

    private void drawStats(GuiGraphics pGuiGraphics, Attributes attributes, int color) {
        pGuiGraphics.drawString(this.font, Component.literal("Race: " + attributes.race()), -107, -71, color);
        pGuiGraphics.drawString(this.font, Component.literal("Health: " + attributes.health()), -107, -71, 0x555555);
        pGuiGraphics.drawString(this.font, Component.literal("Ki: " + attributes.ki()), -107, -71, 0x555555);
        pGuiGraphics.drawString(this.font, Component.literal("Strength: " + attributes.strength()), -107, -71, 0x555555);
        pGuiGraphics.drawString(this.font, Component.literal("Dexterity: " + attributes.dexterity()), -107, -71, 0x555555);
        pGuiGraphics.drawString(this.font, Component.literal("Ki Power: " + attributes.kiPower()), -107, -71, 0x555555);
    }

    private record Attributes(String race, String health, String ki, String strength, String dexterity,
                              String kiPower) {
    }
}
