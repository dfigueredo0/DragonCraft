package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider,
                               CompletableFuture<TagLookup<Block>> pCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, pCompletableFuture, DragonCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BLOOD_RUBY_HELMET.get(),
                        ModItems.BLOOD_RUBY_CHESTPLATE.get(),
                        ModItems.BLOOD_RUBY_LEGGINGS.get(),
                        ModItems.BLOOD_RUBY_BOOTS.get(),
                        ModItems.PARABELLUM_HELMET.get(),
                        ModItems.PARABELLUM_CHESTPLATE.get(),
                        ModItems.PARABELLUM_LEGGINGS.get(),
                        ModItems.PARABELLUM_BOOTS.get(),
                        ModItems.INFERNIUM_HELMET.get(),
                        ModItems.INFERNIUM_CHESTPLATE.get(),
                        ModItems.INFERNIUM_LEGGINGS.get(),
                        ModItems.INFERNIUM_BOOTS.get());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.CHA_LA_RECORD.get(),
                        ModItems.CHOZETSU_DYNAMIC_RECORD.get(),
                        ModItems.DRAGON_SOUL_RECORD.get(),
                        ModItems.MAKAFUSHIGI_ADVENTURE_RECORD.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.AJISA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_AJISA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_AJISA_LOG.get().asItem())
                .add(ModBlocks.AJISA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.AJISA_PLANKS.get().asItem());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
