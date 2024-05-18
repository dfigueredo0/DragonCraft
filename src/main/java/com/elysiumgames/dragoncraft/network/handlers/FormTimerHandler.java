package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;

public class FormTimerHandler {
    /**
     * Checks if the player's transform timer is greater than or equal to the specified threshold.
     *
     * @param entity    The player entity whose transform timer is being checked. Must not be null.
     * @param threshold The threshold value to compare against the player's transformation timer.
     *                  The ki attack can be charged up to "40"%. For example, the threshold could be 5.0D.
     * @return          True if the player's transformation timer is greater than or equal to the threshold,
     *                  otherwise false.
     */
    public static boolean isCharging(Entity entity, double threshold) {
        assert entity != null;

        return entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).formTimer >= threshold;
    }
}
