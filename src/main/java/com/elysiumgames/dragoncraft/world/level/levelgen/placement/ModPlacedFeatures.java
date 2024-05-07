package com.elysiumgames.dragoncraft.world.level.levelgen.placement;

import com.elysiumgames.dragoncraft.DragonCraft;
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
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AJISA_PLACED_KEY = registerKey("ajisa_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> pContext) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = pContext.lookup(Registries.CONFIGURED_FEATURE);
        register(pContext, AJISA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AJISA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.01f, 1), ModBlocks.AJISA_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DragonCraft.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> pContext, ResourceKey<PlacedFeature> pKey, Holder<ConfiguredFeature<?, ?>> pConfiguration, List<PlacementModifier> pModifiers) {
        pContext.register(pKey, new PlacedFeature(pConfiguration, List.copyOf(pModifiers)));
    }
}
