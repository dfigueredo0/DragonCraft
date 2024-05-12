package com.elysiumgames.dragoncraft.client;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.network.packet.AltFunctionC2SPacket;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {
    private static long KI_CHARGE_LASTPRESS = 0L;
    private static long RELEASE_POWER_LASTPRESS = 0L;
    private static long TRANSFORM_LASTPRESS = 0L;
    private static long DETRANSFORM_LASTPRESS = 0L;
    private static long ALTERNATIVE_FUNCTION_LAST_PRESS = 0L;
    private static long SHOOT_KI_BLAST_LASTPRESS = 0L;
    private static long BLOCKING_LASTPRESS = 0L;
    private static long LONG_JUMP_LASTPRESS = 0L;
    private static long CHARGE_ATTACK_LASTPRESS = 0L;

    public static final String KEY_CATEGORY_TUTORIAL = "key.category.dragoncraft.tutorial";

    public static final String KEY_ALT_FUNCTION = registerKey("alt_function");
    public static final String KEY_BLOCK  = registerKey("block");
    public static final String KEY_CHARGE_KI = registerKey("charge_ki");
    public static final String KEY_FLY = registerKey("fly");
    public static final String KEY_JUMP = registerKey("jump");
    public static final String KEY_KI_ATTACK = registerKey("ki_attack");
    public static final String KEY_LOCKED_ON = registerKey("locked_on");
    public static final String KEY_OPEN_STATS = registerKey("open_stats");
    public static final String KEY_RELEASE_POWER = registerKey("release_power");
    public static final String KEY_REVERT_FORM = registerKey("revert_form");
    public static final String KEY_TRANSFORM = registerKey("transform");
    public static final String KEY_TURBO = registerKey("turbo");

    public static final KeyMapping ALT_FUNCTION_KEY = new KeyMapping(KEY_ALT_FUNCTION, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_ALT, KEY_CATEGORY_TUTORIAL) {
        boolean isDown;

        @Override
        public void setDown(boolean down) {
            super.setDown(down);
            if (isDown != down && down) {
                DragonCraft.PACKET_HANDLER.sendToServer(new AltFunctionC2SPacket(0, 0));
//                AltFunctionC2SPacket.pressed(Minecraft.getInstance().player, 0, 0);
                ALTERNATIVE_FUNCTION_LAST_PRESS = System.currentTimeMillis();
            } else if (isDown != down) {
                int dt = (int) (System.currentTimeMillis() - ALTERNATIVE_FUNCTION_LAST_PRESS);
                DragonCraft.PACKET_HANDLER.sendToServer(new AltFunctionC2SPacket(1, dt));
//                AltFunctionC2SPacket.pressed(Minecraft.getInstance().player, 1, dt);
            }
            isDown = down;
        }
    };
    public static final KeyMapping BLOCK_KEY = new KeyMapping(KEY_BLOCK, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Q, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping CHARGING_KEY = new KeyMapping(KEY_CHARGE_KI, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping FLYING_KEY = new KeyMapping(KEY_FLY, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping JUMP_KEY = new KeyMapping(KEY_JUMP, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_SPACE, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping KI_ATTACK_KEY = new KeyMapping(KEY_KI_ATTACK, KeyConflictContext.IN_GAME, InputConstants.Type.MOUSE, GLFW.GLFW_MOUSE_BUTTON_RIGHT, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping LOCKED_ON_KEY = new KeyMapping(KEY_LOCKED_ON, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_TAB, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping OPEN_STATS_KEY = new KeyMapping(KEY_OPEN_STATS, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping RELEASE_POWER_KEY = new KeyMapping(KEY_RELEASE_POWER, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping REVERT_FORM_KEY = new KeyMapping(KEY_REVERT_FORM, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping TRANSFORM_KEY = new KeyMapping(KEY_TRANSFORM, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, KEY_CATEGORY_TUTORIAL);
    public static final KeyMapping TURBO_KEY = new KeyMapping(KEY_TURBO, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_TUTORIAL);

    private static String registerKey(String name) {
        return "key." + DragonCraft.MOD_ID + "." + name;
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT)
    public static class KeyEventListener {
        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (Minecraft.getInstance().screen == null) {
                ALT_FUNCTION_KEY.setToDefault();
                BLOCK_KEY.setToDefault();
                CHARGING_KEY.setToDefault();
                FLYING_KEY.setToDefault();
                JUMP_KEY.setToDefault();
                KI_ATTACK_KEY.setToDefault();
                LOCKED_ON_KEY.setToDefault();
                OPEN_STATS_KEY.setToDefault();
                RELEASE_POWER_KEY.setToDefault();
                REVERT_FORM_KEY.setToDefault();
                TRANSFORM_KEY.setToDefault();
                TURBO_KEY.setToDefault();
            }
        }
    }
}