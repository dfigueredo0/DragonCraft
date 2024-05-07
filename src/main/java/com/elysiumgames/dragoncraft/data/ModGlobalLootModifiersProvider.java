package com.elysiumgames.dragoncraft.data;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, DragonCraft.MOD_ID);
    }

    @Override
    protected void start() {

    }
}
