package com.elysiumgames.dragoncraft.world.item;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.tags.DCTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static Tier BLOOD_RUBY = TierSortingRegistry.registerTier(
            new ForgeTier(3, 786, 7.3F, 2.7F, 24,
                    DCTags.Blocks.NEEDS_BLOOD_RUBY_TOOLS, () -> Ingredient.of(ModItems.BLOOD_RUBY.get())),
            new ResourceLocation(DragonCraft.MOD_ID, "blood_ruby"), List.of(Tiers.IRON), List.of());
    public static Tier PARABELLUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2304, 10.0F, 5.0F, 15,
                    DCTags.Blocks.NEEDS_PARABELLUM_TOOLS, () -> Ingredient.of(ModItems.PARABELLUM_INGOT.get())),
            new ResourceLocation(DragonCraft.MOD_ID, "parabellum"), List.of(Tiers.DIAMOND), List.of());
    public static Tier INFERNIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2592, 12F, 6F, 17,
                    DCTags.Blocks.NEEDS_INFERNIUM_TOOL, () -> Ingredient.of(ModItems.INFERNIUM.get())),
            new ResourceLocation(DragonCraft.MOD_ID, "infernium"), List.of(Tiers.NETHERITE), List.of());
}
