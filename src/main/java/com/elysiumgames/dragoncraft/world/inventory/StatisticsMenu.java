package com.elysiumgames.dragoncraft.world.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class StatisticsMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    private ContainerLevelAccess containerLevelAccess = ContainerLevelAccess.NULL;
    private IItemHandler iItemHandler;
    private boolean bounded = false;
    private Supplier<Boolean> boundItemMatcher = null;
    private Entity boundEntity = null;
    private BlockEntity blockEntity = null;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    public static final HashMap<String, Object> GUI_STATE = new HashMap<>();
    public final Level level;
    public final Player player;
    public int x, y, z;

    public StatisticsMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.STATISTICS_MENU.get(), pContainerId);
        this.player = inv.player;
        this.level = inv.player.level();
        this.iItemHandler = new ItemStackHandler(8);
        BlockPos pos = null;
        if (extraData != null) {
            pos = extraData.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
            this.containerLevelAccess = ContainerLevelAccess.create(this.level, pos);
        }
    }

    @Override
    public Map<Integer, Slot> get() {
        return this.customSlots;
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        if (this.bounded) {
            if (this.boundItemMatcher != null)
                return this.boundItemMatcher.get();
            if (this.blockEntity != null)
                return AbstractContainerMenu.stillValid(this.containerLevelAccess, pPlayer, this.blockEntity.getBlockState().getBlock());
            if (this.boundEntity != null) {
                return this.boundEntity.isPassenger();
            }
        }
        return true;
    }
}
