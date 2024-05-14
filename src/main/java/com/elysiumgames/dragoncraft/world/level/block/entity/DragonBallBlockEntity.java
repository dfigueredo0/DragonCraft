package com.elysiumgames.dragoncraft.world.level.block.entity;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DragonBallBlockEntity extends BlockEntity implements TickableBlockEntity {
    private int ticks = 0, secondsExisted = 0;

    public DragonBallBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.DRAGON_BALL_BE.get(), pPos, pBlockState);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);

        var data = new CompoundTag();
        data.putInt("SecondsExisted", this.secondsExisted);
        pTag.put(DragonCraft.MOD_ID, data);
    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);

        var data = pTag.getCompound(DragonCraft.MOD_ID);
        this.secondsExisted = data.getInt("SecondsExisted");
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void tick() {
        if(this.level == null || this.level.isClientSide()) return;

        if(this.ticks++ % 20 == 0) {
            this.secondsExisted++;
            setChanged();
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
    }
}
