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

public class AlignmentMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    public static final HashMap<String, Object> GUI_STATE = new HashMap<>();
    public final Level level;
    public final Player player;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    public int x, y, z;
    private ContainerLevelAccess containerLevelAccess = ContainerLevelAccess.NULL;
    private IItemHandler iItemHandler;
    private boolean bounded = false;
    private Supplier<Boolean> boundItemMatcher = null;
    private Entity entity = null;
    private BlockEntity blockEntity = null;

    protected AlignmentMenu(int pContainerId, Inventory inventory, FriendlyByteBuf extraData) {
        super(ModMenuTypes.ALIGNMENT_MENU.get(), pContainerId);
        this.player = inventory.player;
        this.level = inventory.player.level();
        this.iItemHandler = new ItemStackHandler(0);
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
                return AbstractContainerMenu.stillValid(this.containerLevelAccess, player, this.blockEntity.getBlockState().getBlock());
            if (this.entity != null)
                return this.entity.acceptsSuccess();
        }
        return true;
    }
}