package com.elysiumgames.dragoncraft.world.level.biome.surface;

import com.elysiumgames.dragoncraft.world.level.biome.ModBiomes;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource GIZARD_DIRT = makeStateRule(ModBlocks.GIZARD_DIRT.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource gizardSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), GIZARD_DIRT));

        return SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.GIZARD_WASTELAND),
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, gizardSurface)
        ));
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
