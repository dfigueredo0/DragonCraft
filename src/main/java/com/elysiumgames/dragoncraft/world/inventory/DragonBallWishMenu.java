package com.elysiumgames.dragoncraft.world.inventory;

import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import com.elysiumgames.dragoncraft.world.level.block.entity.DragonBallBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class DragonBallWishMenu extends AbstractContainerMenu {
    public final DragonBallBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public DragonBallWishMenu(int pContainerId, Inventory inventory, FriendlyByteBuf extraData) {
        this(pContainerId, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(3));
    }

    public DragonBallWishMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.DRAGON_BALL_WISH_MENU.get(), pContainerId);
        checkContainerSize(inv, 3);
        blockEntity = (DragonBallBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            this.addSlot(new SlotItemHandler(iItemHandler, 0, 0, 0));
            this.addSlot(new SlotItemHandler(iItemHandler, 1, 0, 0));
            this.addSlot(new SlotItemHandler(iItemHandler, 2, 0, 0));
        });

        addDataSlots(data);
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, ModBlocks.DRAGON_BALL.get());
    }
}
