package com.elysiumgames.dragoncraft.world.level.biome;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.level.biome.custom.ModOverworldRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerraBlenderAPI {
    public static void registerRegions() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(DragonCraft.MOD_ID, "overworld"), 5));
    }
}
