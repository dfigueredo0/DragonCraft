package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;

import java.text.DecimalFormat;

public class BodyFeaturesHandler {
    public static String eyeColor(Entity entity) {
        assert  entity != null;

        return new DecimalFormat("##").format(entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).eyeColor);
    }

    public static String eyeType(Entity entity) {
        assert  entity != null;

        return new DecimalFormat("##").format(entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).eyeType);
    }

    public static String hairColor(Entity entity) {
        assert  entity != null;

        return new DecimalFormat("##").format(entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).hairColor);
    }

    public static String hairType(Entity entity) {
        assert  entity != null;

        return new DecimalFormat("##").format(entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).hairStyle);
    }
}
