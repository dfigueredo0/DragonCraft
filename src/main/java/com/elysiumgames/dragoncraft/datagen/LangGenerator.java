package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(PackOutput pOutput, String locale) {
        super(pOutput, DragonCraft.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {

    }
}
