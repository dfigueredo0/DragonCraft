package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.tags.DCTags;
import com.elysiumgames.dragoncraft.world.level.block.DCBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DCBlockTagGenerator extends BlockTagsProvider {
    public DCBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DragonCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(DCBlocks.BLOOD_RUBY_BLOCK.get(),
                        DCBlocks.BLOOD_RUBY_ORE.get(),
                        DCBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(),
                        DCBlocks.HELL_BLOOD_RUBY_ORE.get(),
                        DCBlocks.ELATOS_BLOCK.get(),
                        DCBlocks.ELATOS_ORE.get(),
                        DCBlocks.DEEPSLATE_ELATOS_ORE.get(),
                        DCBlocks.HELL_ELATOS_ORE.get(),
                        DCBlocks.INFERNIUM_BLOCK.get(),
                        DCBlocks.HELL_INFERNIUM_ORE.get(),
                        DCBlocks.PARABELLUM_BLOCK.get(),
                        DCBlocks.RAW_PARABELLUM_BLOCK.get(),
                        DCBlocks.PARABELLUM_ORE.get(),
                        DCBlocks.DEEPSLATE_PARABELLUM_ORE.get(),
                        DCBlocks.END_STONE_PARABELLUM_ORE.get(),
                        DCBlocks.JANEMBA_HELL.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(DCBlocks.BLOOD_RUBY_ORE.get(),
                        DCBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(),
                        DCBlocks.HELL_BLOOD_RUBY_ORE.get(),
                        DCBlocks.BLOOD_RUBY_BLOCK.get());

        this.tag(DCTags.Blocks.NEEDS_BLOOD_RUBY_TOOLS)
                .add(DCBlocks.PARABELLUM_ORE.get(),
                        DCBlocks.DEEPSLATE_PARABELLUM_ORE.get(),
                        DCBlocks.END_STONE_PARABELLUM_ORE.get(),
                        DCBlocks.PARABELLUM_BLOCK.get(),
                        DCBlocks.RAW_PARABELLUM_BLOCK.get());

        this.tag(DCTags.Blocks.NEEDS_PARABELLUM_TOOLS)
                .add(DCBlocks.HELL_INFERNIUM_ORE.get(),
                        DCBlocks.INFERNIUM_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
