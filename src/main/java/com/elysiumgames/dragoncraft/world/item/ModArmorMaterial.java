package com.elysiumgames.dragoncraft.world.item;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    BLOOD_RUBY("blood_ruby", 24, Util.make(new EnumMap(ArmorItem.Type.class), (pMap) -> {
        pMap.put(ArmorItem.Type.BOOTS, 2);
        pMap.put(ArmorItem.Type.LEGGINGS, 6);
        pMap.put(ArmorItem.Type.CHESTPLATE, 7);
        pMap.put(ArmorItem.Type.HELMET, 2);
    }), 15, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, () -> Ingredient.of(ModItems.BLOOD_RUBY.get())),
    PARABELLUM("parabellum", 48, Util.make(new EnumMap(ArmorItem.Type.class), (pMap) -> {
        pMap.put(ArmorItem.Type.BOOTS, 3);
        pMap.put(ArmorItem.Type.LEGGINGS, 8);
        pMap.put(ArmorItem.Type.CHESTPLATE, 9);
        pMap.put(ArmorItem.Type.HELMET, 3);
    }), 12, SoundEvents.ARMOR_EQUIP_GENERIC, 2.6F, 0.1F, () -> Ingredient.of(ModItems.PARABELLUM_INGOT.get())),
    INFERNIUM("infernium", 64, Util.make(new EnumMap(ArmorItem.Type.class), (pMap) -> {
        pMap.put(ArmorItem.Type.BOOTS, 5);
        pMap.put(ArmorItem.Type.LEGGINGS, 10);
        pMap.put(ArmorItem.Type.CHESTPLATE, 12);
        pMap.put(ArmorItem.Type.HELMET, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_GENERIC, 3.8F, 0.3F, () -> Ingredient.of(ModItems.INFERNIUM.get()));

    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap(ArmorItem.Type.class), (pMap) -> {
        pMap.put(ArmorItem.Type.BOOTS, 13);
        pMap.put(ArmorItem.Type.LEGGINGS, 15);
        pMap.put(ArmorItem.Type.CHESTPLATE, 16);
        pMap.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModArmorMaterial(String pName, int pDurabilityMultiplier, EnumMap pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.protectionFunctionForType = pProtectionFunctionForType;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue(pRepairIngredient);
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return (Integer)HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return (Integer)this.protectionFunctionForType.get(pType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return DragonCraft.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return DragonCraft.MOD_ID + ":" + this.name;
    }
}
