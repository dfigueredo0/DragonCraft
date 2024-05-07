package com.elysiumgames.dragoncraft.data;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.data.generators.ModBlockStateProvider;
import com.elysiumgames.dragoncraft.data.generators.ModItemModelProvider;
import com.elysiumgames.dragoncraft.data.loot.ModLootTableProvider;
import com.elysiumgames.dragoncraft.data.recipes.ModRecipeProvider;
import com.elysiumgames.dragoncraft.data.tags.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = DragonCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        net.minecraft.data.DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider,
                blockTagGenerator.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModPoiTypesTagsProvider(packOutput, lookupProvider,
                existingFileHelper));
        generator.addProvider(event.includeServer(), new ModBiomeTagsProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModSoundDefinitionsProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(packOutput, "en_us"));
        generator.addProvider(event.includeClient(), new ModPaintingVariantTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeClient(), new ForgeAdvancementProvider(packOutput, lookupProvider, existingFileHelper, List.of(new ModAdvancementProvider())));
    }
}
