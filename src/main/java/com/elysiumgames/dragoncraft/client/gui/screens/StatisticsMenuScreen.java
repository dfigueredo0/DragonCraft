package com.elysiumgames.dragoncraft.client.gui.screens;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.inventory.StatisticsMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;

// TODO: LOOK AT COMMENTS

public class StatisticsMenuScreen extends AbstractContainerScreen<StatisticsMenu> {
    private static final HashMap<String, Object> GUI_STATE = StatisticsMenu.GUI_STATE;
    private static final ResourceLocation TEXTURE_BG = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/statistics_screen.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/4_star_dragonball_gui.png");
    private static final ResourceLocation TEXTURE_ICON = new ResourceLocation(DragonCraft.MOD_ID, "textures/screens/current_icon.png");
    private static final ResourceLocation TEXTURE_ADD_STAT = new ResourceLocation(DragonCraft.MOD_ID, "texture/screens/atlas/image_button_add_stat_button.png");
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
    protected void init() {
        super.init();

        assert this.minecraft != null;
        this.minecraft.pauseGame(false);

        this.healthButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
//                    DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(0, this.x, this.y, this.z));
//                    StatsButtonPacket.handleButtonAction(this.player, 0, this.x, this.y, this.z);
                }
        );
        GUI_STATE.put("button:image_button_health_button", this.healthButton);

        this.kiButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
//                    DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(1, this.x, this.y, this.z));
//                    StatsButtonPacket.handleButtonAction(this.player, 1, this.x, this.y, this.z);
                }
        );
        GUI_STATE.put("button:image_button_ki_button", this.kiButton);

        this.staminaButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
//                    DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(2, this.x, this.y, this.z));
//                    StatsButtonPacket.handleButtonAction(this.player, 2, this.x, this.y, this.z);
                }
        );
        GUI_STATE.put("button:image_button_stamina_button", this.staminaButton);

        this.strengthButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
//                    DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(3, this.x, this.y, this.z));
//                    StatsButtonPacket.handleButtonAction(this.player, 3, this.x, this.y, this.z);
                }
        );

        GUI_STATE.put("button:image_button_strength_button", this.strengthButton);

        this.dexterityButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
//                    DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(4, this.x, this.y, this.z));
//                    StatsButtonPacket.handleButtonAction(this.player, 4, this.x, this.y, this.z);
                }
        );

        GUI_STATE.put("button:image_button_dexterity_button", this.dexterityButton);

        this.kiPowerButton = new ImageButton(
                this.leftPos - 100, this.topPos + 64, 13, 13, 0, 0, 13,
                TEXTURE_ADD_STAT, 13, 26,
                button -> {
//                    DragonCraft.PACKET_HANDLER.sendToServer(new StatsButtonPacket(5, this.x, this.y, this.z));
//                    StatsButtonPacket.handleButtonAction(this.player, 5, this.x, this.y, this.z);
                }
        );

        GUI_STATE.put("button:image_button_ki_power_button", this.kiPowerButton);

    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        pGuiGraphics.blit(TEXTURE_BG, this.x, this.y, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        pGuiGraphics.blit(TEXTURE, this.x - 87, this.y - 18, 0, 0, 350, 200, 350, 300);
        pGuiGraphics.blit(TEXTURE_ICON, this.x - 77, this.y + 179, 0, 0, 24, 24, 24, 24);

        RenderSystem.disableBlend();

    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_player_stats"), -83, -15, 0xFF00FFFE);
//        pGuiGraphics.drawString(this.font, RaceTextProcedure.execute(this.player), 114, -11, 0xFFFFFFFF); // White color
//        pGuiGraphics.drawString(this.font, ClassTextProcedure.execute(this.player), 114, -2, 0xFFFFFFFF);
//        pGuiGraphics.drawString(this.font, AlignmentTextProcedure.execute(this.player), 114, 7, 0xFFFFFFFF);
//        pGuiGraphics.drawString(this.font, FormTextProcedure.execute(this.player), -80, 0, 0xFFFFFFFF);
//        pGuiGraphics.drawString(this.font, SubFormTextProcedure.execute(this.player), -80, 9, 0xFFFFFFFF);
//        pGuiGraphics.drawString(this.font, TPTextProcedure.execute(this.player), -80, 19, 0xFFFF00FF);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_body"), -84, 66, 0xFFFFFFFF);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_agility"), -84, 85, 0xFFFFFFFF);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_spirit"), -84, 104, 0xFFFFFFFF);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_strength"), -84, 123, 0xFFFFFFFF);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_ki_power"), -84, 142, 0xFFFFFFFF);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_mental"), -84, 160, 0xFFFFFFFF);
//        pGuiGraphics.drawString(this.font, MaxHPTextProcedure.execute(this.player), 112, 66, 0xFF0000FF);
//        pGuiGraphics.drawString(this.font, MaxKiTextProcedure.execute(this.player), 112, 76, 0xFFCCCCFF);
//        pGuiGraphics.drawString(this.font, MaxStaminaTextProcedure.execute(this.player), 112, 85, 0xFF668866);
//        pGuiGraphics.drawString(this.font, DefenseTextProcedure.execute(this.player), 112, 95, 0xFF99CCFF);
//        pGuiGraphics.drawString(this.font, StrengthTextProcedure.execute(this.player), 112, 104, 0xFF000066);
//        pGuiGraphics.drawString(this.font, SpeedTextProcedure.execute(this.player), 112, 114, 0xFFCCCCCC);
//        pGuiGraphics.drawString(this.font, KiPowerTextProcedure.execute(this.player), 112, 123, 0xFFFF9999);
//        pGuiGraphics.drawString(this.font, MeleeTextProcedure.execute(this.player), 112, 142, 0xFFFF66CC);
//        pGuiGraphics.drawString(this.font, CurrentDefTextProcedure.execute(this.player), 112, 152, 0xFF00CC99);
//        pGuiGraphics.drawString(this.font, KiDmgTextProcedure.execute(this.player), 112, 161, 0xFFCCFF00);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_static_stats"), 112, 57, 0xFFFFFFFF);
        pGuiGraphics.drawString(this.font, Component.translatable("gui.dragoncraft.statistics_gui.label_current_stats"), 112, 133, 0xFFFFFFFF);
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == GLFW.GLFW_KEY_ESCAPE) {
            Minecraft.getInstance().player.closeContainer();
            return true;
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    @Override
    protected void containerTick() {
        super.containerTick();
    }
}
