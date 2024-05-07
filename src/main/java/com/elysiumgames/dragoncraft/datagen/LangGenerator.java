package com.elysiumgames.dragoncraft.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.fluid.ModFluidTypes;
import com.elysiumgames.dragoncraft.painting.ModPaintings;
import com.elysiumgames.dragoncraft.potion.ModPotions;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.common.Mod;

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

        add(ModBlocks.AJISA_LOG.get(), "Ajisa Log");
        add(ModBlocks.STRIPPED_AJISA_LOG.get(), "Stripped Ajisa Log");
        add(ModBlocks.AJISA_WOOD.get(), "Ajisa Wood");
        add(ModBlocks.STRIPPED_AJISA_WOOD.get(), "Stripped Ajisa Wood");
        add(ModBlocks.AJISA_PLANKS.get(), "Ajisa Planks");
        add(ModBlocks.AJISA_SAPLING.get(), "Ajisa Sapling");
        add(ModBlocks.AJISA_LEAVES.get(), "Ajisa Leaves");
        add(ModBlocks.AJISA_SIGN.get(), "Ajisa Sign");
        add(ModBlocks.AJISA_HANGING_SIGN.get(), "Ajisa Hanging Sign");

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
        add(ModItems.PARABELLUM_HOE.get(), "Parabellum Hoe");
        add(ModItems.INFERNIUM_BOW.get(), "Infernium Bow");
        add(ModItems.INFERNIUM_SWORD.get(), "Infernium Sword");
        add(ModItems.INFERNIUM_SHOVEL.get(), "Infernium Shovel");
        add(ModItems.INFERNIUM_PICKAXE.get(), "Infernium Pickaxe");
        add(ModItems.INFERNIUM_AXE.get(), "Infernium Axe");
        add(ModItems.INFERNIUM_HOE.get(), "Infernium Hoe");

        add(ModItems.BLOOD_RUBY_HELMET.get(), "Blood Ruby Helmet");
        add(ModItems.BLOOD_RUBY_CHESTPLATE.get(), "Blood Ruby Chestplate");
        add(ModItems.BLOOD_RUBY_LEGGINGS.get(), "Blood Ruby Leggings");
        add(ModItems.BLOOD_RUBY_BOOTS.get(), "Blood Ruby Boots");
        add(ModItems.PARABELLUM_HELMET.get(), "Parabellum Helmet");
        add(ModItems.PARABELLUM_CHESTPLATE.get(), "Parabellum Chestplate");
        add(ModItems.PARABELLUM_LEGGINGS.get(), "Parabellum Leggings");
        add(ModItems.PARABELLUM_BOOTS.get(), "Parabellum Boots");
        add(ModItems.INFERNIUM_HELMET.get(), "Infernium Helmet");
        add(ModItems.INFERNIUM_CHESTPLATE.get(), "Infernium Chestplate");
        add(ModItems.INFERNIUM_LEGGINGS.get(), "Infernium Leggings");
        add(ModItems.INFERNIUM_BOOTS.get(), "Infernium Boots");

        add(ModItems.HEALING_WATER_BUCKET.get(), "Healing Water Bucket");

        addRecord(ModItems.CHA_LA_RECORD.get(), "Cha La Head Cha La Record","Hironobu Kageyama - Cha-La Head Cha-La" );
        addRecord(ModItems.CHOZETSU_DYNAMIC_RECORD.get(), "Chōzetsu ☆ Dynamic! Record", "Kazuya Yoshii - Chōzetsu ☆ Dynamic!");
        addRecord(ModItems.DRAGON_SOUL_RECORD.get(), "Dragon Soul Record", "Takayoshi Tanimoto - Dragon Soul");
        addRecord(ModItems.MAKAFUSHIGI_ADVENTURE_RECORD.get(), "Makafushigi Adventure Record", "Hiroki Takahashi - Makafushigi Adventure");

        addPainting(ModPaintings.ARTWORK_93.getId().toString(), "Artwork 93", "Xenoverse 2");

        add(ModFluidTypes.HEALING_WATER_FLUID_TYPE.get().getDescriptionId(), "Healing Water");

        add("creativetab.dragoncraft_tab", "Dragon Craft");
    }

    private void addPainting(String key, String title, String author) {
        key = key.replace(":", ".");

        add("painting." + key + ".title", title);
        add("painting." + key + ".author", author);
    }

    private void addRecord(Item key, String name, String description) {
        add(key.getDescriptionId(), name);
        add(key.getDescriptionId() + ".desc", description);
    }
}
