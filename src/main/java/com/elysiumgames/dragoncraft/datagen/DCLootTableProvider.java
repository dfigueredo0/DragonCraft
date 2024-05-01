package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.datagen.loot.DCBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class DCLootTableProvider {
    public static LootTableProvider create(PackOutput pOutput) {
        return new LootTableProvider(pOutput, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(DCBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
