package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.painting.ModPaintings;
import com.elysiumgames.dragoncraft.potion.ModPotions;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(PackOutput pOutput, String locale) {
        super(pOutput, DragonCraft.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModBlocks.KORIN_PILLAR.get(), "Korin Pillar");
        add(ModBlocks.KORIN_PILLAR_1.get(), "Korin Pillar");
        add(ModBlocks.KORIN_PILLAR_2.get(), "Korin Pillar");

        add(ModBlocks.DEEPSLATE_ELATOS_ORE.get(), "Deepslate Elatos Ore");
        add(ModBlocks.ELATOS_ORE.get(), "Elatos Ore");
        add(ModBlocks.HELL_ELATOS_ORE.get(), "Hell Elatos Ore");
        add(ModBlocks.PARABELLUM_ORE.get(), "Parabellum Ore");
        add(ModBlocks.DEEPSLATE_PARABELLUM_ORE.get(), "Deepslate Parabellum Ore");
        add(ModBlocks.END_STONE_PARABELLUM_ORE.get(), "End Stone Parabellum Ore");
        add(ModBlocks.HELL_INFERNIUM_ORE.get(), "Infernium Ore");
        add(ModBlocks.BLOOD_RUBY_ORE.get(), "Ruby Ore");
        add(ModBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(), "Deepslate Ruby Ore");
        add(ModBlocks.HELL_BLOOD_RUBY_ORE.get(), "Hell Ruby Ore");

        add(ModBlocks.GIZARD_DIRT.get(), "Gizard Dirt");
        add(ModBlocks.DEFAULT_HELL.get(), "Hell Dirt");
        add(ModBlocks.JANEMBA_HELL.get(), "Hell Stone");

        add(ModBlocks.KATCHIN_BLOCK.get(), "Katchin Block");

        add(ModItems.DINOSAUR_MEAT.get(), "Dinosaur Meat");
        add(ModItems.COOK_DINOSAUR_MEAT.get(), "Cooked Dinosaur Meat");
        add(ModItems.RADISH.get(), "Radish");
        add(ModItems.ELATOS.get(), "Elatos");
        add(ModItems.KATCHIN.get(), "Katchin");
        add(ModItems.PARABELLUM_INGOT.get(), "Parabellum Ingot");
        add(ModItems.RAW_PARABELLUM.get(), "Raw Parabellum");
        add(ModItems.INFERNIUM.get(), "Infernium");
        add(ModItems.BLOOD_RUBY.get(), "Blood Ruby");

        add(ModItems.BLOOD_RUBY_SWORD.get(), "Blood Ruby Sword");
        add(ModItems.BLOOD_RUBY_SHOVEL.get(), "Blood Ruby Shovel");
        add(ModItems.BLOOD_RUBY_PICKAXE.get(), "Blood Ruby Pickaxe");
        add(ModItems.BLOOD_RUBY_AXE.get(), "Blood Ruby Axe");
        add(ModItems.BLOOD_RUBY_HOE.get(), "Blood Ruby Hoe");
        add(ModItems.PARABELLUM_SWORD.get(), "Parabellum Sword");
        add(ModItems.PARABELLUM_SHOVEL.get(), "Parabellum Shovel");
        add(ModItems.PARABELLUM_PICKAXE.get(), "Parabellum Pickaxe");
        add(ModItems.PARABELLUM_AXE.get(), "Parabellum Axe");
        add(ModItems.INFERNIUM_HOE.get(), "Parabellum Hoe");
        add(ModItems.INFERNIUM_SWORD.get(), "Infernium Sword");
        add(ModItems.INFERNIUM_SHOVEL.get(), "Infernium Shovel");
        add(ModItems.INFERNIUM_PICKAXE.get(), "Infernium Pickaxe");
        add(ModItems.INFERNIUM_AXE.get(), "Infernium Axe");
        add(ModItems.INFERNIUM_HOE.get(), "Infernium Hoe");

        add(ModItems.HEALING_WATER_BUCKET.get(), "Healing Water Bucket");

        add(ModItems.CHA_LA_RECORD.get(), "Cha La Head Cha La Record");
        addRecordDescription(ModItems.CHA_LA_RECORD.get(), "Hironobu Kageyama - Cha-La Head Cha-La");
        add(ModItems.CHOZETSU_DYNAMIC_RECORD.get(), "Chōzetsu ☆ Dynamic! Record");
        addRecordDescription(ModItems.CHOZETSU_DYNAMIC_RECORD.get(), "Kazuya Yoshii - Chōzetsu ☆ Dynamic!");
        add(ModItems.DRAGON_SOUL_RECORD.get(), "Dragon Soul Record");
        addRecordDescription(ModItems.DRAGON_SOUL_RECORD.get(), "Takayoshi Tanimoto - Dragon Soul");
        add(ModItems.MAKAFUSHIGI_ADVENTURE_RECORD.get(), "Makafushigi Adventure Record");
        addRecordDescription(ModItems.MAKAFUSHIGI_ADVENTURE_RECORD.get(), "Hiroki Takahashi - Makafushigi Adventure");

        addPainting(ModPaintings.ARTWORK_93.get(), "Artwork 93", "Xenoverse 2");

        addPotion(ModPotions.DIVINE_WATER.get(), "Divine Water");
        addPotion(ModPotions.ULTRA_DIVINE_WATER.get(), "Ultra Divine Water");

        add("creativetab.dragoncraft_tab", "Dragon Craft");
    }

    private void addPotion(Potion key, String name) {
        String potionId = key.toString().substring(29);
        String[] pName = name.split(" ");
        String splash = pName[0] + "Splash" + pName[pName.length - 1];
        String lingering = pName[0] + "Lingering" + pName[pName.length - 1];
        add(key.toString(), name);
        add("item.minecraft.splash_potion.effect.dragoncraft" + potionId, splash);
        add("item.minecraft.lingering_potion.effect.dragoncraft" + potionId, lingering);
    }

    private void addPainting(PaintingVariant key, String pName, String pAuthor) {
        add(key + ".title", pName);
        add(key + ".author", pAuthor);
    }

    private void addRecordDescription(Item key, String name) {
        add(key + ".desc", name);
    }
}
