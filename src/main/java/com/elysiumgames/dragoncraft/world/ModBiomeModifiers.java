package com.elysiumgames.dragoncraft.world;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.tags.ModTags;
import com.elysiumgames.dragoncraft.world.entity.ModEntities;
import com.elysiumgames.dragoncraft.world.level.levelgen.placement.ModPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_AJISA = registerKey("add_tree_ajisa");
    public static final ResourceKey<BiomeModifier> ADD_ELATOS_ORE = registerKey("add_elatos_ore");
    public static final ResourceKey<BiomeModifier> ADD_BLOOD_RUBY_ORE = registerKey("add_blood_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_PARABELLUM_ORE = registerKey("add_parabellum_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_PARABELLUM_ORE = registerKey("add_end_parabellum_ore");

    public static final ResourceKey<BiomeModifier> SPAWN_SAIBAMEN  = registerKey("spawn_saibamen");
    public static final ResourceKey<BiomeModifier> SPAWN_DRAGON  = registerKey("spawn_dragon");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_AJISA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.IS_NAMEK),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.AJISA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_ELATOS_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ELATOS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_BLOOD_RUBY_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLOOD_RUBY_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_PARABELLUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PARABELLUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_PARABELLUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_PARABELLUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(SPAWN_SAIBAMEN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.IS_GIZARD_WASTELAND),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SAIBAMEN.get(), 8, 1, 3))));
        context.register(SPAWN_DRAGON, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.DRAGON.get(), 1, 1, 2))));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(DragonCraft.MOD_ID, name));
    }
}
