package com.elysiumgames.dragoncraft.client.gui.screens;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.network.handlers.BodyFeaturesHandler;
import com.elysiumgames.dragoncraft.network.handlers.SkinTypeHandler;
import com.elysiumgames.dragoncraft.network.packet.CharacterCustomizationPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class CharacterCustomizationScreen extends Screen {
    private static final Component TITLE = Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_screen");
    private static final ResourceLocation TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/stats_screen.png");
    private static final ResourceLocation INPUT_TEXTURE = new ResourceLocation(DragonCraft.MOD_ID + "textures/screens/atlas/input.png");
    private final int imageWidth, imageHeight;
    private Player player;
    private int leftPos, topPos;
    private Button next, back, button, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15;

    public CharacterCustomizationScreen(BlockPos pBlockPos) {
        super(TITLE);
        this.imageWidth = 224;
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

        this.next = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button_next"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(0, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 0, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos + 68, this.topPos + 59, 38, 20).build());

        this.back = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button_back"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(1, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 1, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos + 29, this.topPos + 59, 38, 20).build());

        this.button = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(2, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 2, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 94, this.topPos - 58, 8, 20).build());

        this.button1 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button1"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(3, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 3, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 69, this.topPos - 58, 8, 20).build());

        this.button2 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button2"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(4, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 4, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 94, this.topPos - 15, 8, 20).build());

        this.button3 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button3"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(5, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 5, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 69, this.topPos - 15, 8, 20).build());

        this.button4 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button4"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(6, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 6, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 61, this.topPos - 15, 8, 20).build());

        this.button5 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button5"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(7, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 7, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 105, this.topPos + 25, 8, 20).build());

        this.button6 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button6"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(8, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 8, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 82, this.topPos + 25, 8, 20).build());

        this.button7 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button7"),
                e -> {
                    if (SkinTypeHandler.hasSkin(this.player, 0)) {
                        DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(9, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                        CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 9, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                    }
                }).bounds(this.leftPos + -40, this.topPos + 25, 8, 20).build());

        this.button8 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button8"), e -> {
            if (SkinTypeHandler.hasSkin(this.player, 1)) {
                DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(10, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 10, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
            }
        }).bounds(this.leftPos - 105, this.topPos + 50, 8, 20).build());

        this.button9 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button9"),
                e -> {
                    if (SkinTypeHandler.hasSkin(this.player, 1)) {
                        DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(11, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                        CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 11, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                    }
                }).bounds(this.leftPos - 82, this.topPos + 50, 8, 20).build());

        this.button10 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button10"),
                e -> {
                    if (SkinTypeHandler.hasSkin(this.player, 0)) {
                        DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(12, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                        CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 12, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                    }
                }).bounds(this.leftPos - 17, this.topPos + 25, 8, 20).build());

        this.button11 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button11"),
                e -> {
                    if (SkinTypeHandler.hasSkin(this.player, 3)) {
                        DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(13, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                        CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 13, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                    }
                }).bounds(this.leftPos - 40, this.topPos + 50, 8, 20).build());

        this.button12 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button12"),
                e -> {
                    if (SkinTypeHandler.hasSkin(this.player, 3)) {
                        DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(14, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                        CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 14, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                    }
                }).bounds(this.leftPos - 17, this.topPos + 50, 8, 20).build());

        this.button13 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button13"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(15, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 15, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 37, this.topPos - 15, 8, 20).build());

        this.button14 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button14"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(16, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 16, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 61, this.topPos - 58, 8, 20).build());

        this.button15 = addRenderableWidget(Button.builder(Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.button15"),
                e -> {
                    DragonCraft.PACKET_HANDLER.sendToServer(new CharacterCustomizationPacket(17, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ()));
                    CharacterCustomizationPacket.handleButtonAction((ServerPlayer) this.player, 17, this.player.getBlockX(), this.player.getBlockY(), this.player.getBlockZ());
                }).bounds(this.leftPos - 37, this.topPos - 58, 8, 20).build());
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.setShaderTexture(0, TEXTURE);
        pGuiGraphics.blit(TEXTURE, this.leftPos - 115, this.topPos - 84, 0, 0, this.imageWidth, this.imageHeight);

        RenderSystem.setShaderTexture(0, INPUT_TEXTURE);
        pGuiGraphics.blit(INPUT_TEXTURE, this.leftPos - 94, this.topPos - 57, 0, 0, 32, 18);
        pGuiGraphics.blit(INPUT_TEXTURE, this.leftPos - 93, this.topPos - 14, 0, 0, 32, 18);

        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.HUMANOID, 1, 0)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human1.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human1.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.HUMANOID, 2, 0)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human2.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human2.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.HUMANOID, 3, 0)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human3.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human3.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.HUMANOID, 4, 0)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human4.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human4.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.HUMANOID, 5, 0)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human5.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_human5.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 1, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian1.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian1.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 2, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian2.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian2.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 3, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian3.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian3.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 4, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian4.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian4.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 5, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian5.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_namekian5.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 1, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian1.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian1.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 2, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian2.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian2.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 3, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian3.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian3.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 4, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian4.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian4.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.NAMEKIAN, 5, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian5.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_namekian5.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }

        RenderSystem.setShaderTexture(0, INPUT_TEXTURE);
        pGuiGraphics.blit(INPUT_TEXTURE, this.leftPos - 61, this.topPos - 14, 0, 0, 32, 18);
        pGuiGraphics.blit(INPUT_TEXTURE, this.leftPos - 61, this.topPos - 57, 0, 0, 32, 18);

        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 1, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon1.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon1.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 2, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon2.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon2.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 3, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon3.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon3.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 4, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon4.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon4.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 5, 1)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon5.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin_frost_demon5.png"), this.leftPos - 98, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 1, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 2, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon2.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon2.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 3, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon3.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon3.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 4, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon4.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon4.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 5, 2)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon5.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin2_frost_demon5.png"), this.leftPos - 33, this.topPos + 27, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 1, 3)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon1.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon1.png"), this.leftPos - 98, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 2, 3)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon2.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon2.png"), this.leftPos - 98, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 3, 3)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon3.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon3.png"), this.leftPos - 98, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 4, 3)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon4.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon4.png"), this.leftPos - 98, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 5, 3)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon5.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin3_frost_demon5.png"), this.leftPos - 98, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 1, 4)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon1.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon1.png"), this.leftPos - 33, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 2, 4)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon2.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon2.png"), this.leftPos - 33, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 3, 4)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon3.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon3.png"), this.leftPos - 33, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 4, 4)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon4.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon4.png"), this.leftPos - 33, this.topPos + 52, 0, 0, 16, 16);
        }
        if (SkinTypeHandler.hasSkinColor(this.player, SkinTypeHandler.SkinType.FROST_DEMON, 5, 4)) {
            RenderSystem.setShaderTexture(0, new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon5.png"));
            pGuiGraphics.blit(new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/skin4_frost_demon5.png"), this.leftPos - 33, this.topPos + 52, 0, 0, 16, 16);
        }

        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        pGuiGraphics.drawString(this.font, TITLE, -110, -80, 0x404040);
        pGuiGraphics.drawString(this.font, Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.label_hair"), -69, -70, -1);
        pGuiGraphics.drawString(this.font, Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.label_eyes"), -69, -29, -1);
        pGuiGraphics.drawString(this.font, Component.translatable("gui." + DragonCraft.MOD_ID + ".character_customization_gui.label_skin"), -68, 15, -1);
        pGuiGraphics.drawString(this.font, BodyFeaturesHandler.eyeType(this.player), -83, -10, -1);
        pGuiGraphics.drawString(this.font, BodyFeaturesHandler.eyeColor(this.player), -50, -10, 0x00FFFF);
        pGuiGraphics.drawString(this.font, BodyFeaturesHandler.hairType(this.player), -83, -54, -1);
        pGuiGraphics.drawString(this.font, BodyFeaturesHandler.hairColor(this.player), -50, -54, 0x00FFFF);
    }
}
