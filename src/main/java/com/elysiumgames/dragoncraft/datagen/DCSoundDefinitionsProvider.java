package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class DCSoundDefinitionsProvider extends SoundDefinitionsProvider {
    protected DCSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, DragonCraft.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {

    }
}
