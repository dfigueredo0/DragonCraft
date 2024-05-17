package com.elysiumgames.dragoncraft.client.gui.screens;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.network.packet.StatsButtonPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;

// TODO: LOOK AT COMMENTS

public class StatisticsMenuScreen extends Screen {
    private static final ResourceLocation TEXTURE_BG = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/stats_screen.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/4_star_dragonball_gui.png");
    private static final ResourceLocation TEXTURE_ICON = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/current_icon.png");
    private static final ResourceLocation TEXTURE_ADD_STAT = new ResourceLocation(DragonCraft.MOD_ID, "texture/screens/atlas/image_button_add_stat_button.png");
    private static final Component TITLE = Component.translatable("gui." + DragonCraft.MOD_ID + ".stats_screen");
    private static final Component HEALTH_TT = Component.translatable("gui." + DragonCraft.MOD_ID + ".stats_screen.label_health");
    private static final Component STAMINA_TT = Component.translatable("gui." + DragonCraft.MOD_ID + ".stats_screen.label_stamina");
    private static final Component KI_TT = Component.translatable("gui." + DragonCraft.MOD_ID + ".stats_screen.label_ki");
    private static final Component STRENGTH_TT = Component.translatable("gui." + DragonCraft.MOD_ID + ".stats_screen.label_strength");
    private static final Component DEXTERITY_TT = Component.translatable("gui." + DragonCraft.MOD_ID + ".stats_screen.label_dexterity");
    private static final Component KI_POWER_TT = Component.translatable("gui." + DragonCraft.MOD_ID + ".stats_screen.label_ki_power");
    private final int imageWidth, imageHeight;
    private Player player;
    private int leftPos, topPos;
    protected ImageButton healthButton;
    protected ImageButton kiButton;
    protected ImageButton staminaButton;
    protected ImageButton strengthButton;
    protected ImageButton dexterityButton;
    protected ImageButton kiPowerButton;

    public StatisticsMenuScreen(BlockPos blockPos) {
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

        this.healthButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
                        DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(0));
                        StatsButtonPacket.handleButtonAction(this.player, 0);
                }
        );
        healthButton.setTooltip(Tooltip.create(HEALTH_TT));

        this.kiButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
                        DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(1));
                        StatsButtonPacket.handleButtonAction(this.player, 1);
                }
        );
        kiButton.setTooltip(Tooltip.create(KI_TT));

        this.staminaButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
                       DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(2));
                        StatsButtonPacket.handleButtonAction(this.player, 2);
                }
        );
        staminaButton.setTooltip(Tooltip.create(STAMINA_TT));

        this.strengthButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
                        DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(3));
                        StatsButtonPacket.handleButtonAction(this.player, 3);
                }
        );
        strengthButton.setTooltip(Tooltip.create(STRENGTH_TT));

        this.dexterityButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
                        DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(4));
                        StatsButtonPacket.handleButtonAction(this.player, 4);
                }
        );
        dexterityButton.setTooltip(Tooltip.create(DEXTERITY_TT));

        this.kiPowerButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
                      DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(5));
                      StatsButtonPacket.handleButtonAction(this.player, 5);
                }
        );
        kiPowerButton.setTooltip(Tooltip.create(KI_POWER_TT));


    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        pGuiGraphics.blit(TEXTURE_BG, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        pGuiGraphics.blit(TEXTURE, this.leftPos - 87, this.topPos - 18, 0, 0, 350, 200, 350, 300);
        pGuiGraphics.blit(TEXTURE_ICON, this.leftPos - 77, this.topPos + 179, 0, 0, 24, 24, 24, 24);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
//      pGuiGraphics.drawString(this.font, RaceTextProcedure.execute(this.player), 114, -11, 0xFFFFFFFF); // White color
//      pGuiGraphics.drawString(this.font, ClassTextProcedure.execute(this.player), 114, -2, 0xFFFFFFFF);
//      pGuiGraphics.drawString(this.font, AlignmentTextProcedure.execute(this.player), 114, 7, 0xFFFFFFFF);
//      pGuiGraphics.drawString(this.font, FormTextProcedure.execute(this.player), -80, 0, 0xFFFFFFFF);
//      pGuiGraphics.drawString(this.font, SubFormTextProcedure.execute(this.player), -80, 9, 0xFFFFFFFF);
//      pGuiGraphics.drawString(this.font, TPTextProcedure.execute(this.player), -80, 19, 0xFFFF00FF);////
//      pGuiGraphics.drawString(this.font, MaxHPTextProcedure.execute(this.player), 112, 66, 0xFF0000FF);
//      pGuiGraphics.drawString(this.font, MaxKiTextProcedure.execute(this.player), 112, 76, 0xFFCCCCFF);
//      pGuiGraphics.drawString(this.font, MaxStaminaTextProcedure.execute(this.player), 112, 85, 0xFF668866);
//      pGuiGraphics.drawString(this.font, DefenseTextProcedure.execute(this.player), 112, 95, 0xFF99CCFF);
//      pGuiGraphics.drawString(this.font, StrengthTextProcedure.execute(this.player), 112, 104, 0xFF000066);
//      pGuiGraphics.drawString(this.font, SpeedTextProcedure.execute(this.player), 112, 114, 0xFFCCCCCC);
//      pGuiGraphics.drawString(this.font, KiPowerTextProcedure.execute(this.player), 112, 123, 0xFFFF9999);
//      pGuiGraphics.drawString(this.font, MeleeTextProcedure.execute(this.player), 112, 142, 0xFFFF66CC);
//      pGuiGraphics.drawString(this.font, CurrentDefTextProcedure.execute(this.player), 112, 152, 0xFF00CC99);
//      pGuiGraphics.drawString(this.font, KiDmgTextProcedure.execute(this.player), 112, 161, 0xFFCCFF00);
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == GLFW.GLFW_KEY_ESCAPE) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.closeContainer();
            return true;
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }
}
