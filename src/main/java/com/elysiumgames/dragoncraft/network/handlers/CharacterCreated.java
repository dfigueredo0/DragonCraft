package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;

public class CharacterCreated {
    public static boolean execute(Entity entity) {
        if (entity == null) {
            return false;
        }
        return entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).createdCharacter;
    }
}
