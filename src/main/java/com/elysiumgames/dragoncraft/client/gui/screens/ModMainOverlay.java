package com.elysiumgames.dragoncraft.client.gui.screens;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.network.handlers.CharacterCreationHandler;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ModMainOverlay {
    private static final ResourceLocation BAR_TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/bar.png");
    private static final ResourceLocation POWER_BAR_TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/power_level_bar.png");
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int width = event.getWindow().getWidth();
        int height = event.getWindow().getHeight();
        Level level = null;
        double x = 0, y = 0, z = 0;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        GuiGraphics guiGraphics = event.getGuiGraphics();

        if (localPlayer != null) {
            level = localPlayer.level();
            x = localPlayer.getX();
            y = localPlayer.getY();
            z = localPlayer.getZ();
        }
        RenderSystem.enableBlend();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(
                GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO
        );
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        if (CharacterCreationHandler.isCharacterCreated(localPlayer)) { //TODO: maybe change?
            RenderSystem.setShaderTexture(0, BAR_TEXTURE);
            guiGraphics.blit(BAR_TEXTURE, (width / 2) - 171, (height / 2) - 94, 0, 0, 128, 8, 128, 8);
            RenderSystem.setShaderTexture(0, BAR_TEXTURE);
            guiGraphics.blit(BAR_TEXTURE, (width / 2) - 178, (height / 2) - 87, 0, 0, 128, 8, 128, 8);
            RenderSystem.setShaderTexture(0, BAR_TEXTURE);
            guiGraphics.blit(POWER_BAR_TEXTURE, (width / 2) - 185, (height / 2) - 80, 0, 0, 128, 8, 128, 8);
            RenderSystem.setShaderTexture(0, POWER_BAR_TEXTURE);
            guiGraphics.blit(POWER_BAR_TEXTURE, (width / 2) + -180, (height / 2) + -72, 0.0F, 0.0F, 45, 8, 45, 8);
        }
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
