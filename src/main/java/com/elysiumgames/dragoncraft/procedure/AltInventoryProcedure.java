package com.elysiumgames.dragoncraft.procedure;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

import java.util.logging.Level;

public class AltInventoryProcedure {
    public static class Open {
        public static void execute(LevelAccessor levelAccessor, Entity entity) {
            if (entity == null)
                return;
            DragonCraft.queueServerWork(1, () -> {

            });
        }
    }

    public static class Close {
        public static void execute(Entity entity) {

        }
    }

}
