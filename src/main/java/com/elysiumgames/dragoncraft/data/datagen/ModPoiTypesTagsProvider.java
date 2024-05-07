package com.elysiumgames.dragoncraft.data.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypesTagsProvider extends PoiTypeTagsProvider {
    public ModPoiTypesTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pCompletableFuture, DragonCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        super.addTags(pProvider);
    }
}
