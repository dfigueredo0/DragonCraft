package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DCItemTagGenerator extends ItemTagsProvider {
    public DCItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider,
                              CompletableFuture<TagLookup<Block>> pCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, pCompletableFuture, DragonCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
