package com.elysiumgames.dragoncraft.client.gui.screens.inventory;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.inventory.AltInventoryMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.SlotItemHandler;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;

public class AltInventoryScreen extends AbstractContainerScreen<AltInventoryMenu> {
    private static final HashMap<String, Object> GUI_STATE = AltInventoryMenu.GUI_STATE;
    private static final ResourceLocation TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/gui/alt_inventory.png");
    private final Level level;
    private final Player player;
    private final int x, y ,z;

    public AltInventoryScreen(AltInventoryMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.level = pMenu.entity.level();
        this.player = pMenu.entity;
        this.x = pMenu.x;
        this.y = pMenu.y;
        this.z = pMenu.z;
        this.imageWidth = 176;
        this.imageHeight = 185;

    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void onClose() {
        super.onClose();
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == GLFW.GLFW_KEY_ESCAPE) {
            assert this.minecraft != null;
            assert this.minecraft.player != null;
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/top.png"), this.leftPos + 7, this.topPos + 26, 0, 0, 16, 16, 16, 16);
        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/tshirt.png"),this.leftPos + 7, this.topPos + 44, 0, 0, 16, 16, 16, 16);
        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/pants.png"),this.leftPos + 7, this.topPos + 62, 0, 0, 16, 16, 16, 16);
        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/boots.png"),this.leftPos + 25, this.topPos + 26, 0, 0, 16, 16, 16, 16);
        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/wristbands.png"),this.leftPos + 25, this.topPos + 44, 0, 0, 16, 16, 16, 16);
        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/belt.png"),this.leftPos + 25, this.topPos + 62, 0, 0, 16, 16, 16, 16);
        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/belt2.png"),this.leftPos + 25, this.topPos + 62, 0, 0, 16, 16, 16, 16);
        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/weights.png"),this.leftPos + 43, this.topPos + 26, 0, 0, 16, 16, 16, 16);
        pGuiGraphics.blit(new ResourceLocation("dragoncraft:textures/screens/atlas/scouter.png"),this.leftPos + 43, this.topPos + 44, 0, 0, 16, 16, 16, 16);

        RenderSystem.disableBlend();
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.alt_inventory.label_inventory"), 6, 81, 0xFF9D00);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.alt_inventory.label_extra_slots"), 6, 7, 0xFF9D00);
        super.renderLabels(pGuiGraphics, pMouseX, pMouseY);
    }
}
