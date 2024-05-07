package com.elysiumgames.dragoncraft.world.level.levelgen.feature;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AJISA_KEY = registerKey("ajisa");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ELATOS_KEY = registerKey("elatos_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BLOOD_RUBY_KEY = registerKey("blood_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PARABELLUM_KEY = registerKey("parabellum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_PARABELLUM_KEY = registerKey("end_parabellum_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        // TODO: Need replaceable for hell stone, check if it should be done like stone or end stone.
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldElatosOres = List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.ELATOS_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ELATOS_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldParabellumOres = List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.PARABELLUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_PARABELLUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldBloodRubyOres = List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.BLOOD_RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get().defaultBlockState()));

        register(pContext, AJISA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.AJISA_LOG.get()),
                new StraightTrunkPlacer(5, 3, 3),
                BlockStateProvider.simple(ModBlocks.AJISA_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(ModBlocks.GIZARD_DIRT.get())).build());

        register(pContext, OVERWORLD_ELATOS_KEY, Feature.ORE, new OreConfiguration(overworldElatosOres, 7));
        register(pContext, OVERWORLD_BLOOD_RUBY_KEY, Feature.ORE, new OreConfiguration(overworldBloodRubyOres, 8));
        register(pContext, OVERWORLD_PARABELLUM_KEY, Feature.ORE, new OreConfiguration(overworldParabellumOres, 5));
        register(pContext, END_PARABELLUM_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.END_STONE_PARABELLUM_ORE.get().defaultBlockState(), 5));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DragonCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> pContext, ResourceKey<ConfiguredFeature<?, ?>> pKey, F pFeature, FC pConfiguration) {
        pContext.register(pKey, new ConfiguredFeature<>(pFeature, pConfiguration));
    }
}
