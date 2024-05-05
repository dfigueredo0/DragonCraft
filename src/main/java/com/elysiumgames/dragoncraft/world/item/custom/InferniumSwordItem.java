package com.elysiumgames.dragoncraft.world.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class InferniumSwordItem extends SwordItem {
    private static final double PROBABILITY = 0.35D;
    public InferniumSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
            double chance = Math.random();
            if (!pTarget.isOnFire() && chance < PROBABILITY)
                pTarget.setSecondsOnFire(3);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
