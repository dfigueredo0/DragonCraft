package com.elysiumgames.dragoncraft.world.dimension;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.level.biome.ModBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<LevelStem> HTC_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(DragonCraft.MOD_ID, "hyperbolic_time_chamber"));
    public static final ResourceKey<Level> HTC_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DragonCraft.MOD_ID, "hyperbolic_time_chamber"));
    public static final ResourceKey<DimensionType> HTC_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(DragonCraft.MOD_ID, "hyperbolic_time_chamber_type"));
    public static final ResourceKey<LevelStem> OTHERWORLD_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(DragonCraft.MOD_ID, "otherworld"));
    public static final ResourceKey<Level> OTHERWORLD_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DragonCraft.MOD_ID, "otherworld"));
    public static final ResourceKey<DimensionType> OTHERWORLD_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(DragonCraft.MOD_ID, "otherworld_type"));
    public static final ResourceKey<LevelStem> SPACE_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(DragonCraft.MOD_ID, "space"));
    public static final ResourceKey<Level> SPACE_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DragonCraft.MOD_ID, "space"));
    public static final ResourceKey<DimensionType> SPACE_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(DragonCraft.MOD_ID, "space_type"));
    public static final ResourceKey<LevelStem> NAMEK_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(DragonCraft.MOD_ID, "namek"));
    public static final ResourceKey<Level> NAMEK_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DragonCraft.MOD_ID, "namek"));
    public static final ResourceKey<DimensionType> NAMEK_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(DragonCraft.MOD_ID, "namek_type"));

    //TODO: Change some values for each dimension
    public static void bootstrapType(BootstapContext<DimensionType> pContext) {
        pContext.register(NAMEK_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), //FixedTime
                true, // hasSkyLight
                false, //hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, //ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0) /* TODO: custom Raids for freiza's soldiers */
        ));

        pContext.register(SPACE_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), //FixedTime
                true, // hasSkyLight
                false, //hasCeiling
                false, // ultraWarm
                true, // natural
                5.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, //ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0) /* TODO: custom Raids for space pirates */
        ));

        pContext.register(OTHERWORLD_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), //FixedTime
                true, // hasSkyLight
                false, //hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, //ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)
        ));

        pContext.register(HTC_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), //FixedTime
                true, // hasSkyLight
                false, //hasCeiling
                false, // ultraWarm
                true, // natural
                10.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                64, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, //ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0) /* TODO: custom Raids for freiza's soldiers */
        ));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> pContext) {
        pContext.register(NAMEK_KEY, NamekLevelStem(pContext));
        //pContext.register(SPACE_KEY, SpaceLevelStem(pContext));
        //pContext.register(OTHERWORLD_KEY, OtherworldLevelStem(pContext));
        //pContext.register(HTC_KEY, HyperbolicTimeChamberLevelStem(pContext));
    }

    //TODO: Implement Rest of Dimensions
    private static LevelStem HyperbolicTimeChamberLevelStem(BootstapContext<LevelStem> pContext) {
        ModRegistries.initialize(pContext);

        return null;
    }

    private static LevelStem OtherworldLevelStem(BootstapContext<LevelStem> pContext) {
        ModRegistries.initialize(pContext);

        return null;
    }

    private static LevelStem SpaceLevelStem(BootstapContext<LevelStem> pContext) {
        ModRegistries.initialize(pContext);

        return null;
    }

    private static @NotNull LevelStem NamekLevelStem(BootstapContext<LevelStem> pContext) {
        ModRegistries.initialize(pContext);

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), ModRegistries.BIOME_REGISTRY.getOrThrow(ModBiomes.NAMEKIAN_PLAINS)),
                                Pair.of(Climate.parameters(0.0F, 0.0F, 1.3F, 0.0F, 0.0F, 0.0F, 0.0F), ModRegistries.BIOME_REGISTRY.getOrThrow(ModBiomes.NAMEKIAN_FORESTS)),
                                Pair.of(Climate.parameters(0.0F, 0.1F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F), ModRegistries.BIOME_REGISTRY.getOrThrow(ModBiomes.NAMEKIAN_OCEANS)),
                                Pair.of(Climate.parameters(0.0F, 0.0F, -1.2F, 0.4F, 0.4F, 0.0F, 0.0F), ModRegistries.BIOME_REGISTRY.getOrThrow(ModBiomes.NAMEKIAN_ISLANDS))
                                ))),
                ModRegistries.NOISE_GEN_SETTINGS.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        return new LevelStem(ModRegistries.DIM_TYPES.getOrThrow(ModDimensions.NAMEK_DIM_TYPE), noiseBasedChunkGenerator);
    }

    private static class ModRegistries {
        public static HolderGetter<Biome> BIOME_REGISTRY;
        public static HolderGetter<DimensionType> DIM_TYPES;
        public static HolderGetter<NoiseGeneratorSettings> NOISE_GEN_SETTINGS;

        public static void initialize(BootstapContext<LevelStem> context) {
            BIOME_REGISTRY = context.lookup(Registries.BIOME);
            DIM_TYPES = context.lookup(Registries.DIMENSION_TYPE);
            NOISE_GEN_SETTINGS = context.lookup(Registries.NOISE_SETTINGS);
        }
    }
}
