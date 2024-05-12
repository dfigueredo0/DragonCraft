package com.elysiumgames.dragoncraft.data.tags;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.tags.ModTags;
import com.elysiumgames.dragoncraft.world.level.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsProvider extends BiomeTagsProvider {
    public ModBiomeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, DragonCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//       this.tag(ModTags.Biomes.IS_NAMEK)
//                .add(ModBiomes.NAMEKIAN_PLAINS)
//                .add(ModBiomes.NAMEKIAN_FORESTS)
//                .add(ModBiomes.NAMEKIAN_ISLANDS)
//                .add(ModBiomes.NAMEKIAN_OCEANS);
////                TODO: Fix Couldn't define tag dragoncraft:is_namek as it is missing following references: dragoncraft:namekian_plains,dragoncraft:namekian_forest,dragoncraft:namekian_islands,dragoncraft:namekian_oceans
//          this.tag(ModTags.Biomes.IS_GIZARD_WASTELAND)
//                .add(ModBiomes.GIZARD_WASTELAND);

    }
}
