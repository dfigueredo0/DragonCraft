package com.elysiumgames.dragoncraft.world.level.biome;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import static com.elysiumgames.dragoncraft.data.worldgen.biome.ModOverworldBiomes.gizardWastelandBiome;
import static com.elysiumgames.dragoncraft.data.worldgen.biome.NamekianBiomes.*;

public class ModBiomes {
    public static final ResourceKey<Biome> GIZARD_WASTELAND = register("gizard_wasteland");
    public static final ResourceKey<Biome> NAMEKIAN_PLAINS = register("namekian_plains");
    public static final ResourceKey<Biome> NAMEKIAN_FORESTS = register("namekian_forest");
    public static final ResourceKey<Biome> NAMEKIAN_ISLANDS = register("namekian_islands");
    public static final ResourceKey<Biome> NAMEKIAN_OCEANS = register("namekian_oceans");

    public static void bootstrap(BootstapContext<Biome> pContext) {
        pContext.register(GIZARD_WASTELAND, gizardWastelandBiome(pContext));
        pContext.register(NAMEKIAN_PLAINS, namekianPlainsBiome(pContext));
        pContext.register(NAMEKIAN_FORESTS, namekianForestBiome(pContext));
        pContext.register(NAMEKIAN_ISLANDS, namekianIslandBiome(pContext));
        pContext.register(NAMEKIAN_OCEANS, namekianOceansBiome(pContext));
    }

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(DragonCraft.MOD_ID, name));
    }
}
