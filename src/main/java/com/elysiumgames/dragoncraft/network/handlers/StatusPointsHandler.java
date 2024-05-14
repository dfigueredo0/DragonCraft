package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;

public class StatusPointsHandler {
    public static void increaseNeededPoints(Entity entity) {
        assert entity != null;

        double val = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).allocations + 1;
        entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.allocations++;
            if (capability.isLegendary)
                capability.neededStatPoints = 5 + (capability.allocations * 1.15);
            else
                capability.neededStatPoints = 5 + (capability.allocations * 1.3);
            capability.syncPlayerVariables(entity);
        });
    }
}
