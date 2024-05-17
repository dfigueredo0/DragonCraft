package com.elysiumgames.dragoncraft.world.item.custom;

import com.elysiumgames.dragoncraft.world.item.ModArmorMaterial;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP = new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>()
            .put(ModArmorMaterial.BLOOD_RUBY, new MobEffectInstance(MobEffects.REGENERATION, 200, 1))
            .put(ModArmorMaterial.INFERNIUM, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 1))
            .build();

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (!level.isClientSide() && hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            if (hasPlayerCorrectArmorOn(entry.getKey(), player)) {
                addEffectToPlayer(player, entry.getValue());
            }
        }
    }

    private void addEffectToPlayer(Player player, MobEffectInstance mobEffect) {
        if (!player.hasEffect(mobEffect.getEffect())) {
            player.addEffect(new MobEffectInstance(mobEffect.getEffect(),
                    mobEffect.getDuration(), mobEffect.getAmplifier()));
        }
    }

    private boolean hasPlayerCorrectArmorOn(ArmorMaterial material, Player player) {
        return player.getInventory().armor.stream().allMatch(itemStack -> {
            if (!(itemStack.getItem() instanceof ArmorItem armorItem))
                return false;
            return armorItem.getMaterial() == material;
        });

    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        return player.getInventory().armor.stream().noneMatch(ItemStack::isEmpty);
    }
}
