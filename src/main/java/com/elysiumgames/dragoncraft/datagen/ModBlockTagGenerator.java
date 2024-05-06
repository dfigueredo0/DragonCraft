package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.tags.DCTags;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DragonCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOOD_RUBY_BLOCK.get(),
                        ModBlocks.BLOOD_RUBY_ORE.get(),
                        ModBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(),
                        ModBlocks.HELL_BLOOD_RUBY_ORE.get(),
                        ModBlocks.ELATOS_BLOCK.get(),
                        ModBlocks.ELATOS_ORE.get(),
                        ModBlocks.DEEPSLATE_ELATOS_ORE.get(),
                        ModBlocks.HELL_ELATOS_ORE.get(),
                        ModBlocks.INFERNIUM_BLOCK.get(),
                        ModBlocks.HELL_INFERNIUM_ORE.get(),
                        ModBlocks.PARABELLUM_BLOCK.get(),
                        ModBlocks.RAW_PARABELLUM_BLOCK.get(),
                        ModBlocks.PARABELLUM_ORE.get(),
                        ModBlocks.DEEPSLATE_PARABELLUM_ORE.get(),
                        ModBlocks.END_STONE_PARABELLUM_ORE.get(),
                        ModBlocks.JANEMBA_HELL.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLOOD_RUBY_ORE.get(),
                        ModBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(),
                        ModBlocks.HELL_BLOOD_RUBY_ORE.get(),
                        ModBlocks.BLOOD_RUBY_BLOCK.get());

        this.tag(DCTags.Blocks.NEEDS_BLOOD_RUBY_TOOLS)
                .add(ModBlocks.PARABELLUM_ORE.get(),
                        ModBlocks.DEEPSLATE_PARABELLUM_ORE.get(),
                        ModBlocks.END_STONE_PARABELLUM_ORE.get(),
                        ModBlocks.PARABELLUM_BLOCK.get(),
                        ModBlocks.RAW_PARABELLUM_BLOCK.get());

        this.tag(DCTags.Blocks.NEEDS_PARABELLUM_TOOLS)
                .add(ModBlocks.HELL_INFERNIUM_ORE.get(),
                        ModBlocks.INFERNIUM_BLOCK.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.AJISA_LOG.get())
                .add(ModBlocks.AJISA_WOOD.get())
                .add(ModBlocks.STRIPPED_AJISA_LOG.get())
                .add(ModBlocks.STRIPPED_AJISA_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.AJISA_PLANKS.get());


    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
