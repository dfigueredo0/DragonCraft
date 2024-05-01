package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class DCGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public DCGlobalLootModifiersProvider(PackOutput output) {
        super(output, DragonCraft.MOD_ID);
    }

    @Override
    protected void start() {

    }
}
