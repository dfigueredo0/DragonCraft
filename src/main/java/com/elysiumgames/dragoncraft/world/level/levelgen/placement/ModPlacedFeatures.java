package com.elysiumgames.dragoncraft.world.level.levelgen.placement;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.level.biome.ModBiomes;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import com.elysiumgames.dragoncraft.world.level.levelgen.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AJISA_PLACED_KEY = registerKey("ajisa_plains_placed");


    public static final ResourceKey<PlacedFeature> ELATOS_ORE_PLACED_KEY = registerKey("elatos_ore_placed");
    public static final ResourceKey<PlacedFeature> BLOOD_RUBY_ORE_PLACED_KEY = registerKey("blood_ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> PARABELLUM_ORE_PLACED_KEY = registerKey("parabellum_ore_placed");
    public static final ResourceKey<PlacedFeature> END_PARABELLUM_ORE_PLACED_KEY = registerKey("end_parabellum_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> pContext) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = pContext.lookup(Registries.CONFIGURED_FEATURE);

        register(pContext, AJISA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AJISA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.01f, 1), ModBlocks.AJISA_SAPLING.get()));

        register(pContext, ELATOS_ORE_PLACED_KEY,  configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ELATOS_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(pContext, BLOOD_RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_BLOOD_RUBY_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(pContext, PARABELLUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PARABELLUM_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(72))));
        register(pContext, END_PARABELLUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_PARABELLUM_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DragonCraft.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> pContext, ResourceKey<PlacedFeature> pKey, Holder<ConfiguredFeature<?, ?>> pConfiguration, List<PlacementModifier> pModifiers) {
        pContext.register(pKey, new PlacedFeature(pConfiguration, List.copyOf(pModifiers)));
    }
}
