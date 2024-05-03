package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.item.DCItems;
import com.elysiumgames.dragoncraft.world.level.block.DCBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class DCRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> PARABELLUM_SMELTABLES = List.of(DCItems.RAW_PARABELLUM.get(), DCBlocks.PARABELLUM_ORE.get(), DCBlocks.DEEPSLATE_PARABELLUM_ORE.get(), DCBlocks.END_STONE_PARABELLUM_ORE.get());
    private static final List<ItemLike> ELATOS_SMELTABLES = List.of(DCBlocks.ELATOS_ORE.get(), DCBlocks.DEEPSLATE_ELATOS_ORE.get(), DCBlocks.HELL_ELATOS_ORE.get());
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(DCBlocks.BLOOD_RUBY_ORE.get(), DCBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(), DCBlocks.HELL_BLOOD_RUBY_ORE.get());
    private static final List<ItemLike> INFERNIUM_SMELTABLES = List.of(DCBlocks.HELL_INFERNIUM_ORE.get());

    public DCRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, DCItems.ELATOS.get(), RecipeCategory.MISC, DCBlocks.ELATOS_BLOCK.get(),
                "dragoncraft:elatos", "elatos", "dragoncraft:elatos_block", "elatos");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, DCItems.RAW_PARABELLUM.get(), RecipeCategory.MISC, DCBlocks.RAW_PARABELLUM_BLOCK.get(),
                "dragoncraft:raw_parabellum", "parabellum", "dragoncraft:raw_parabellum_block", "parabellum");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, DCItems.PARABELLUM_INGOT.get(), RecipeCategory.MISC, DCBlocks.PARABELLUM_BLOCK.get(),
                "dragoncraft:parabellum_ingot", "parabellum", "dragoncraft:parabellum_block", "parabellum");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, DCItems.BLOOD_RUBY.get(), RecipeCategory.MISC, DCBlocks.BLOOD_RUBY_BLOCK.get(),
                "dragoncraft:blood_ruby", "blood_ruby", "dragoncraft:blood_ruby_block", "blood_ruby");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, DCItems.INFERNIUM.get(), RecipeCategory.MISC, DCBlocks.INFERNIUM_BLOCK.get(),
                "dragoncraft:infernium", "infernium", "dragoncraft:infernium_block", "infernium");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DCItems.ELATOS.get(), 9).unlockedBy("has_elatos_block", inventoryTrigger(ItemPredicate.Builder.item().of(DCBlocks.ELATOS_BLOCK.get()).build()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DCItems.PARABELLUM_INGOT.get(), 9).unlockedBy("has_parabellum_block", inventoryTrigger(ItemPredicate.Builder.item().of(DCBlocks.PARABELLUM_BLOCK.get()).build()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DCItems.BLOOD_RUBY.get(), 9).unlockedBy("has_ruby_block", inventoryTrigger(ItemPredicate.Builder.item().of(DCBlocks.BLOOD_RUBY_BLOCK.get()).build()));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DCItems.INFERNIUM.get(), 9).unlockedBy("has_infernium_block", inventoryTrigger(ItemPredicate.Builder.item().of(DCBlocks.INFERNIUM_BLOCK.get()).build()));

        oreSmelting(pWriter, PARABELLUM_SMELTABLES, RecipeCategory.MISC, DCItems.PARABELLUM_INGOT.get(), 0.35f, 200, "parabellum");
        oreBlasting(pWriter, PARABELLUM_SMELTABLES, RecipeCategory.MISC, DCItems.PARABELLUM_INGOT.get(), 0.35f, 100, "parabellum");
        oreSmelting(pWriter, ELATOS_SMELTABLES, RecipeCategory.MISC, DCItems.ELATOS.get(), 0.15f, 200, "elatos");
        oreBlasting(pWriter, ELATOS_SMELTABLES, RecipeCategory.MISC, DCItems.ELATOS.get(), 0.15f, 100, "elatos");
        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, DCItems.BLOOD_RUBY.get(), 0.25f, 200, "ruby");
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, DCItems.BLOOD_RUBY.get(), 0.25f, 100, "ruby");
        oreSmelting(pWriter, INFERNIUM_SMELTABLES, RecipeCategory.MISC, DCItems.INFERNIUM.get(), 0.45f, 200, "infernium");
        oreBlasting(pWriter, INFERNIUM_SMELTABLES, RecipeCategory.MISC, DCItems.INFERNIUM.get(), 0.45f, 100, "infernium");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(pFinishedRecipeConsumer, DragonCraft.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
