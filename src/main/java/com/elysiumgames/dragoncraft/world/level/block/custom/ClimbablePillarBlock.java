package com.elysiumgames.dragoncraft.world.level.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ClimbablePillarBlock extends Block {

    public ClimbablePillarBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(2.5, 0.0, 2.5, 13.5, 16.0, 13.5);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return true;
    }


    @Override
    public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        if (entity.horizontalCollision) {
            Vec3 initialVec = entity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, initialVec.y + 0.2D, initialVec.z);
            entity.setDeltaMovement(climbVec.x, climbVec.y, climbVec.z);
            return true;
        }
        return true;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 8;
    }
}
