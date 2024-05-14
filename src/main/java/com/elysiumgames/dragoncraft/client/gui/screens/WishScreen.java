package com.elysiumgames.dragoncraft.client.gui.screens;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.utils.Constants;
import com.elysiumgames.dragoncraft.world.level.block.entity.DragonBallBlockEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

public class WishScreen extends Screen {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/gui/dragon_ball_wish_gui.png");
    private static final Component TITLE = Component.translatable("gui." + DragonCraft.MOD_ID + ".wish_screen");
    private static final Component TEST_BUTTON = Component.translatable("gui." + DragonCraft.MOD_ID + "wish_screen.button.test_wish_button");
    private final BlockPos blockPos;
    private final int imageWidth, imageHeight;
    private DragonBallBlockEntity blockEntity;
    private int leftPos, topPos;
    private Button button;

    public WishScreen(BlockPos pBlockPos) {
        super(TITLE);
        blockPos = pBlockPos;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;


        assert this.minecraft != null;
        Level level = this.minecraft.level;

        assert level != null;
        BlockEntity blockEntity = level.getBlockEntity(this.blockPos);

        if (blockEntity instanceof DragonBallBlockEntity ballBlockEntity) {
            this.blockEntity = ballBlockEntity;
        } else {
            Constants.LOG.info("BlockEntity at %s is not of type DragonBallBlockEntity!\n{}", this.blockPos);
            return;
        }

        this.button = addRenderableWidget(Button.builder(
                        TEST_BUTTON,
                        this::handleWishButton)
                .bounds(this.leftPos + (this.imageWidth / 2), this.topPos + (this.imageHeight / 2), 20, 20)
                .tooltip(Tooltip.create(TEST_BUTTON))
                .build());
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        pGuiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        pGuiGraphics.drawString(this.font, TITLE, this.leftPos + 8, this.topPos + 8, 0x404040, false);
    }

    private void handleWishButton(Button button) {

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
