package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.item.DCItems;
import com.elysiumgames.dragoncraft.world.level.block.DCBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(PackOutput pOutput, String locale) {
        super(pOutput, DragonCraft.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(DCBlocks.KORIN_PILLAR.get(), "Korin Pillar");
        add(DCBlocks.KORIN_PILLAR_1.get(), "Korin Pillar");
        add(DCBlocks.KORIN_PILLAR_2.get(), "Korin Pillar");

        add(DCBlocks.DEEPSLATE_ELATOS_ORE.get(), "Deepslate Elatos Ore");
        add(DCBlocks.ELATOS_ORE.get(), "Elatos Ore");
        add(DCBlocks.HELL_ELATOS_ORE.get(), "Hell Elatos Ore");
        add(DCBlocks.PARABELLUM_ORE.get(), "Parabellum Ore");
        add(DCBlocks.DEEPSLATE_PARABELLUM_ORE.get(), "Deepslate Parabellum Ore");
        add(DCBlocks.END_STONE_PARABELLUM_ORE.get(), "End Stone Parabellum Ore");
        add(DCBlocks.HELL_INFERNIUM_ORE.get(), "Infernium Ore");
        add(DCBlocks.BLOOD_RUBY_ORE.get(), "Ruby Ore");
        add(DCBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(), "Deepslate Ruby Ore");
        add(DCBlocks.HELL_BLOOD_RUBY_ORE.get(), "Hell Ruby Ore");

        add(DCBlocks.GIZARD_DIRT.get(), "Gizard Dirt");
        add(DCBlocks.DEFAULT_HELL.get(), "Hell Dirt");
        add(DCBlocks.JANEMBA_HELL.get(), "Hell Stone");

        add(DCBlocks.KATCHIN_BLOCK.get(), "Katchin Block");

        add(DCItems.DINOSAUR_MEAT.get(), "Dinosaur Meat");
        add(DCItems.COOK_DINOSAUR_MEAT.get(), "Cooked Dinosaur Meat");
        add(DCItems.RADISH.get(), "Radish");
        add(DCItems.ELATOS.get(), "Elatos");
        add(DCItems.KATCHIN.get(), "Katchin");
        add(DCItems.PARABELLUM_INGOT.get(), "Parabellum Ingot");
        add(DCItems.RAW_PARABELLUM.get(), "Raw Parabellum");
        add(DCItems.INFERNIUM.get(), "Infernium");
        add(DCItems.BLOOD_RUBY.get(), "Blood Ruby");

        add(DCItems.BLOOD_RUBY_SWORD.get(), "Blood Ruby Sword");
        add(DCItems.BLOOD_RUBY_SHOVEL.get(), "Blood Ruby Shovel");
        add(DCItems.BLOOD_RUBY_PICKAXE.get(), "Blood Ruby Pickaxe");
        add(DCItems.BLOOD_RUBY_AXE.get(), "Blood Ruby Axe");
        add(DCItems.BLOOD_RUBY_HOE.get(), "Blood Ruby Hoe");
        add(DCItems.PARABELLUM_SWORD.get(), "Parabellum Sword");
        add(DCItems.PARABELLUM_SHOVEL.get(), "Parabellum Shovel");
        add(DCItems.PARABELLUM_PICKAXE.get(), "Parabellum Pickaxe");
        add(DCItems.PARABELLUM_AXE.get(), "Parabellum Axe");
        add(DCItems.INFERNIUM_HOE.get(), "Parabellum Hoe");
        add(DCItems.INFERNIUM_SWORD.get(), "Infernium Sword");
        add(DCItems.INFERNIUM_SHOVEL.get(), "Infernium Shovel");
        add(DCItems.INFERNIUM_PICKAXE.get(), "Infernium Pickaxe");
        add(DCItems.INFERNIUM_AXE.get(), "Infernium Axe");
        add(DCItems.INFERNIUM_HOE.get(), "Infernium Hoe");

        add("creativetab.dragoncraft_tab", "Dragon Craft");
    }
}
