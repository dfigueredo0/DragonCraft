package com.elysiumgames.dragoncraft.world.level.block.custom;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class HealingWaterBlock extends LiquidBlock {
    public HealingWaterBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        super(pFluid, pProperties);
    }

    @Override
    public void stepOn(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull Entity pEntity) {
        if (pEntity instanceof LivingEntity livingEntity) {
            double newTimerValue = pEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).healingWaterTimer + 1.0D;
            pEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.healingWaterTimer = newTimerValue;
                capability.syncPlayerVariables(pEntity);
            });
            if (pEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).healingWaterTimer >= 2.0) {
                double healedHealth = pEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxHealth * 0.05D;
                livingEntity.heal((float) healedHealth);
            }
        }
    }
}
