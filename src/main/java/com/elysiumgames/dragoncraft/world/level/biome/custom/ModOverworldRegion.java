package com.elysiumgames.dragoncraft.world.level.biome.custom;

import com.elysiumgames.dragoncraft.world.level.biome.ModBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils.*;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.NEUTRAL, Temperature.WARM, Temperature.HOT)
                .humidity(Humidity.ARID, Humidity.DRY, Humidity.NEUTRAL)
                .continentalness(Continentalness.NEAR_INLAND, Continentalness.INLAND,Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
                .depth(Depth.span(Depth.SURFACE, Depth.FLOOR))
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.GIZARD_WASTELAND));

        builder.build().forEach(mapper);
    }
}
