package com.elysiumgames.dragoncraft.world.item;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.fluid.ModFluids;
import com.elysiumgames.dragoncraft.sound.ModSounds;
import com.elysiumgames.dragoncraft.world.entity.ModEntities;
import com.elysiumgames.dragoncraft.world.food.ModFoods;
import com.elysiumgames.dragoncraft.world.item.custom.ModArmorItem;
import com.elysiumgames.dragoncraft.world.item.custom.InferniumSwordItem;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DragonCraft.MOD_ID);

    public static final RegistryObject<Item> ELATOS = ITEMS.register("elatos", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY = ITEMS.register("blood_ruby" , () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM = ITEMS.register("infernium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PARABELLUM = ITEMS.register("raw_parabellum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_INGOT = ITEMS.register("parabellum_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KATCHIN = ITEMS.register("katchin", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINOSAUR_MEAT = ITEMS.register("dinosaur_meat", () -> new Item(new Item.Properties().food(ModFoods.DINOSAUR_MEAT)));
    public static final RegistryObject<Item> COOK_DINOSAUR_MEAT = ITEMS.register("cooked_dinosaur_meat", () -> new Item(new Item.Properties().food(ModFoods.COOK_DINOSAUR_MEAT)));
    public static final RegistryObject<Item> RADISH = ITEMS.register("radish", () -> new Item(new Item.Properties().food(ModFoods.RADISH)));

    public static final RegistryObject<Item> BLOOD_RUBY_SWORD = ITEMS.register("blood_ruby_sword",
            () -> new SwordItem(ModToolTiers.BLOOD_RUBY ,3, -1.8F, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_SHOVEL = ITEMS.register("blood_ruby_shovel",
            () -> new ShovelItem(ModToolTiers.BLOOD_RUBY ,1.5F, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_PICKAXE = ITEMS.register("blood_ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BLOOD_RUBY ,1, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_AXE = ITEMS.register("blood_ruby_axe",
            () -> new AxeItem(ModToolTiers.BLOOD_RUBY ,6.0F, -2.5F, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_HOE = ITEMS.register("blood_ruby_hoe",
            () -> new HoeItem(ModToolTiers.BLOOD_RUBY ,-2, -1.0F, new Item.Properties()));

    public static final RegistryObject<Item> PARABELLUM_SWORD = ITEMS.register("parabellum_sword",
            () -> new SwordItem(ModToolTiers.PARABELLUM ,3, -1.8F, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_SHOVEL = ITEMS.register("parabellum_shovel",
            () -> new ShovelItem(ModToolTiers.PARABELLUM ,1.5F, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_PICKAXE = ITEMS.register("parabellum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PARABELLUM ,1, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_AXE = ITEMS.register("parabellum_axe",
            () -> new AxeItem(ModToolTiers.PARABELLUM ,5.2F, -2.5F, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_HOE = ITEMS.register("parabellum_hoe",
            () -> new HoeItem(ModToolTiers.PARABELLUM ,-3, 0.0F, new Item.Properties()));

    public static final RegistryObject<Item> INFERNIUM_SWORD = ITEMS.register("infernium_sword",
            () -> new InferniumSwordItem(ModToolTiers.INFERNIUM ,3, -1.8F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_SHOVEL = ITEMS.register("infernium_shovel",
            () -> new ShovelItem(ModToolTiers.INFERNIUM ,1.5F, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_PICKAXE = ITEMS.register("infernium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.INFERNIUM ,1, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_AXE = ITEMS.register("infernium_axe",
            () -> new AxeItem(ModToolTiers.INFERNIUM ,6.2F, -2.5F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_HOE = ITEMS.register("infernium_hoe",
            () -> new HoeItem(ModToolTiers.INFERNIUM ,-2, 0.4F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_BOW = ITEMS.register("infernium_bow",
            () -> new BowItem(new Item.Properties().durability(764)));

    public static final RegistryObject<Item> BLOOD_RUBY_HELMET = ITEMS.register("blood_ruby_helmet",
            () -> new ModArmorItem(ModArmorMaterial.BLOOD_RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_CHESTPLATE = ITEMS.register("blood_ruby_chestplate",
            () -> new ModArmorItem(ModArmorMaterial.BLOOD_RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_LEGGINGS = ITEMS.register("blood_ruby_leggings",
            () -> new ModArmorItem(ModArmorMaterial.BLOOD_RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_BOOTS = ITEMS.register("blood_ruby_boots",
            () -> new ModArmorItem(ModArmorMaterial.BLOOD_RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_HELMET = ITEMS.register("parabellum_helmet",
            () -> new ArmorItem(ModArmorMaterial.PARABELLUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_CHESTPLATE = ITEMS.register("parabellum_chestplate",
            () -> new ArmorItem(ModArmorMaterial.PARABELLUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_LEGGINGS = ITEMS.register("parabellum_leggings",
            () -> new ArmorItem(ModArmorMaterial.PARABELLUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_BOOTS = ITEMS.register("parabellum_boots",
            () -> new ArmorItem(ModArmorMaterial.PARABELLUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_HELMET = ITEMS.register("infernium_helmet",
            () -> new ModArmorItem(ModArmorMaterial.INFERNIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_CHESTPLATE = ITEMS.register("infernium_chestplate",
            () -> new ModArmorItem(ModArmorMaterial.INFERNIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_LEGGINGS = ITEMS.register("infernium_leggings",
            () -> new ModArmorItem(ModArmorMaterial.INFERNIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_BOOTS = ITEMS.register("infernium_boots",
            () -> new ModArmorItem(ModArmorMaterial.INFERNIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> AJISA_SIGN = ITEMS.register("ajisa_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.AJISA_SIGN.get(), ModBlocks.AJISA_WALL_SIGN.get()));
    public static final RegistryObject<Item> AJISA_HANGING_SIGN = ITEMS.register("ajisa_hanging_sign",
            () -> new HangingSignItem(ModBlocks.AJISA_HANGING_SIGN.get(), ModBlocks.AJISA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> CHA_LA_RECORD = ITEMS.register("cha_la_record",
            () -> new RecordItem(4, ModSounds.CHA_LA_HEAD_CHA_LA, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 2220));
    public static final RegistryObject<Item> CHOZETSU_DYNAMIC_RECORD = ITEMS.register("chozetsu_dynamic_record",
            () -> new RecordItem(4, ModSounds.CHOZETSU_DYNAMIC, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 1660));
    public static final RegistryObject<Item> DRAGON_SOUL_RECORD = ITEMS.register("dragon_soul_record",
            () -> new RecordItem(4, ModSounds.DRAGON_SOUL, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 1680));
    public static final RegistryObject<Item> MAKAFUSHIGI_ADVENTURE_RECORD = ITEMS.register("makafushigi_adventure_record",
            () -> new RecordItem(4, ModSounds.MAKAFUSHIGI_ADVENTURE, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 2100));

    public static final RegistryObject<Item> HEALING_WATER_BUCKET = ITEMS.register("healing_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_HEALING_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> SAIBAMEN_SPAWN_EGG = ITEMS.register("saibamen_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SAIBAMEN, 0x395613, 0xb7bd52, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
