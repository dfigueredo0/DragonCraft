package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = DragonCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new DCRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), DCLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new DCItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new DCBlockStateProvider(packOutput, existingFileHelper));

        DCBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new DCBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new DCItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new DCGlobalLootModifiersProvider(packOutput));
        generator.addProvider(event.includeServer(), new DCPoiTypesTagsProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new DCSoundDefinitionsProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(), new LangGenerator(packOutput, "en_us"));

        generator.addProvider(event.includeServer(), new DCWorldGenProvider(packOutput, lookupProvider));
    }
}
