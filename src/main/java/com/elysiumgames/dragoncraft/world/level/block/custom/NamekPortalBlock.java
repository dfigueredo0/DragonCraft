package com.elysiumgames.dragoncraft.world.level.block.custom;

import com.elysiumgames.dragoncraft.world.dimension.ModDimensions;
import com.elysiumgames.dragoncraft.world.level.levelgen.portal.NamekTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class NamekPortalBlock extends Block {
    public NamekPortalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            handleNamekPortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handleNamekPortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverLevel) {
            MinecraftServer minecraftServer = serverLevel.getServer();
            ResourceKey<Level> resourceKey = player.level().dimension() == ModDimensions.NAMEK_LEVEL_KEY ? Level.OVERWORLD : ModDimensions.NAMEK_LEVEL_KEY;

            ServerLevel portalDimension = minecraftServer.getLevel(resourceKey);
            if (portalDimension != null && !player.isPassenger()) {
                if (resourceKey == ModDimensions.NAMEK_LEVEL_KEY) {
                    player.changeDimension(portalDimension, new NamekTeleporter(pPos, true));
                } else {
                    player.changeDimension(portalDimension, new NamekTeleporter(pPos, false));
                }
            }
        }
    }
}
