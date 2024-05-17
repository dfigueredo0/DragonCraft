package com.elysiumgames.dragoncraft.world.food;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties DINOSAUR_MEAT = new FoodProperties.Builder().nutrition(4).saturationMod(0.35f).meat().build();
    public static final FoodProperties COOK_DINOSAUR_MEAT = new FoodProperties.Builder().nutrition(10).saturationMod(0.875f).meat().build();
    public static final FoodProperties RADISH = new FoodProperties.Builder().nutrition(3).saturationMod(0.25f).build();
}
