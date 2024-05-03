package com.elysiumgames.dragoncraft.world.item;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.food.DCFoods;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DCItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DragonCraft.MOD_ID);

    public static final RegistryObject<Item> ELATOS = ITEMS.register("elatos", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY = ITEMS.register("blood_ruby" , () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM = ITEMS.register("infernium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PARABELLUM = ITEMS.register("raw_parabellum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_INGOT = ITEMS.register("parabellum_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KATCHIN = ITEMS.register("katchin", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DINOSAUR_MEAT = ITEMS.register("dinosaur_meat", () -> new Item(new Item.Properties().food(DCFoods.DINOSAUR_MEAT)));
    public static final RegistryObject<Item> COOK_DINOSAUR_MEAT = ITEMS.register("cooked_dinosaur_meat", () -> new Item(new Item.Properties().food(DCFoods.COOK_DINOSAUR_MEAT)));
    public static final RegistryObject<Item> RADISH = ITEMS.register("radish", () -> new Item(new Item.Properties().food(DCFoods.RADISH)));

    public static final RegistryObject<Item> BLOOD_RUBY_SWORD = ITEMS.register("blood_ruby_sword",
            () -> new SwordItem(DCToolTiers.BLOOD_RUBY ,3, -1.8F, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_SHOVEL = ITEMS.register("blood_ruby_shovel",
            () -> new ShovelItem(DCToolTiers.BLOOD_RUBY ,1.5F, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_PICKAXE = ITEMS.register("blood_ruby_pickaxe",
            () -> new PickaxeItem(DCToolTiers.BLOOD_RUBY ,1, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_AXE = ITEMS.register("blood_ruby_axe",
            () -> new AxeItem(DCToolTiers.BLOOD_RUBY ,6.0F, -2.5F, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_RUBY_HOE = ITEMS.register("blood_ruby_hoe",
            () -> new HoeItem(DCToolTiers.BLOOD_RUBY ,-2, -1.0F, new Item.Properties()));

    public static final RegistryObject<Item> PARABELLUM_SWORD = ITEMS.register("parabellum_sword",
            () -> new SwordItem(DCToolTiers.PARABELLUM ,3, -1.8F, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_SHOVEL = ITEMS.register("parabellum_shovel",
            () -> new ShovelItem(DCToolTiers.PARABELLUM ,1.5F, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_PICKAXE = ITEMS.register("parabellum_pickaxe",
            () -> new PickaxeItem(DCToolTiers.PARABELLUM ,1, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_AXE = ITEMS.register("parabellum_axe",
            () -> new AxeItem(DCToolTiers.PARABELLUM ,5.2F, -2.5F, new Item.Properties()));
    public static final RegistryObject<Item> PARABELLUM_HOE = ITEMS.register("parabellum_hoe",
            () -> new HoeItem(DCToolTiers.PARABELLUM ,-3, 0.0F, new Item.Properties()));

    public static final RegistryObject<Item> INFERNIUM_SWORD = ITEMS.register("blood_ruby_sword",
            () -> new SwordItem(DCToolTiers.INFERNIUM ,3, -1.8F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_SHOVEL = ITEMS.register("parabellum_shovel",
            () -> new ShovelItem(DCToolTiers.INFERNIUM ,1.5F, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_PICKAXE = ITEMS.register("parabellum_pickaxe",
            () -> new PickaxeItem(DCToolTiers.INFERNIUM ,1, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_AXE = ITEMS.register("parabellum_axe",
            () -> new AxeItem(DCToolTiers.INFERNIUM ,6.2F, -2.5F, new Item.Properties()));
    public static final RegistryObject<Item> INFERNIUM_HOE = ITEMS.register("parabellum_hoe",
            () -> new HoeItem(DCToolTiers.INFERNIUM ,-2, 0.4F, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
