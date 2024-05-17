package com.elysiumgames.dragoncraft.world.inventory;

import com.elysiumgames.dragoncraft.network.handlers.AltInventoryHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AltInventoryMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    private ContainerLevelAccess containerLevelAccess = ContainerLevelAccess.NULL;
    private IItemHandler iItemHandler;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private boolean bounded = false;
    private Supplier<Boolean> boundItemMatcher = null;
    private Entity boundEntity = null;
    private BlockEntity blockEntity = null;
    private final Level level;
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 8;  // must be the number of slots you have!
    public static final HashMap<String, Object> GUI_STATE = new HashMap<>();
    public int x, y, z;
    public Player entity;

    public AltInventoryMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), extraData);
    }

    public AltInventoryMenu(int pContainerId, Inventory inv, BlockEntity entity, FriendlyByteBuf extraData) {
        super(ModMenuTypes.ALT_INVENTORY_MENU.get(), pContainerId);
        this.entity = inv.player;
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

        if (pos != null) {
            if (extraData.readableBytes() == 1) {
                byte hand = extraData.readByte();
                ItemStack itemStack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
                this.boundItemMatcher = () -> itemStack == ((hand == 0) ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
                itemStack.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(capability -> {
                    this.iItemHandler = capability;
                    this.bounded = true;
                });
            } else if (extraData.readableBytes() > 1) {
                byte hand = extraData.readByte();
                this.boundEntity = this.level.getEntity(extraData.readVarInt());
                if (this.boundEntity != null) {
                    this.boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(capability -> {
                        this.iItemHandler = capability;
                        this.bounded = true;
                    });
                }
            } else {
                this.blockEntity = this.level.getBlockEntity(pos);
                if (this.blockEntity != null) {
                    this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(capability -> {
                        this.iItemHandler = capability;
                        this.bounded = true;
                    });
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            int x = 7 + (i / 3) * 18;
            int y = 26 + (i % 3) * 18;
            this.addSlot(new SlotItemHandler(this.iItemHandler, i, x, y));
        }

        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        AltInventoryHandler.Open.execute(this.level, this.entity);
    }

    @Override
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        AltInventoryHandler.Close.execute(this.entity);
        if (!this.bounded && pPlayer instanceof ServerPlayer serverPlayer) {
            ItemStack itemstack = this.getCarried();
            if (!itemstack.isEmpty()) {
                if (serverPlayer.isAlive() && !serverPlayer.hasDisconnected()) {
                    for (int i = 0; i < this.iItemHandler.getSlots(); i++) {
                        if (i > 7)
                            serverPlayer.getInventory().add(this.iItemHandler.extractItem(i, this.iItemHandler.getStackInSlot(i).getCount(), false));
                    }
                } else {
                    for (int j = 0; j < this.iItemHandler.getSlots(); j++) {
                        if (j > 7)
                            serverPlayer.drop(this.iItemHandler.extractItem(j, this.iItemHandler.getStackInSlot(j).getCount(), false), false);
                    }
                }
            }
        }
    }

    @Override
    public Map<Integer, Slot> get() {
        return this.customSlots;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    protected boolean moveItemStackTo(ItemStack pStack, int pStartIndex, int pEndIndex, boolean pReverseDirection) {
        boolean changed =  false;
        int index = pStartIndex;
        if (pReverseDirection) {
            index -= pEndIndex;
        }
        if (pStack.isStackable()) {
            while (!pStack.isEmpty() && pReverseDirection ? index < pStartIndex : index >= pEndIndex) {
                Slot slot = this.getSlot(index);
                ItemStack itemStack = slot.getItem();
                if (slot.mayPlace(itemStack) && !itemStack.isEmpty() && ItemStack.isSameItemSameTags(pStack, itemStack)) {
                    int count = itemStack.getCount() + pStack.getCount();
                    int maxSize = Math.min(slot.getMaxStackSize(), pStack.getMaxStackSize());

                    if (count <= maxSize) {
                        pStack.setCount(0);
                        itemStack.setCount(count);
                        slot.setChanged();
                        changed = true;
                    } else if (itemStack.getCount() < maxSize) {
                        pStack.shrink(maxSize - itemStack.getCount());
                        itemStack.setCount(maxSize);
                        slot.setChanged();
                        changed = true;
                    }
                }
                if (pReverseDirection) {
                    index--;
                } else {
                    index++;
                }
            }
        }

        if (!pStack.isEmpty()) {
            index = pReverseDirection ? pEndIndex - 1 : pStartIndex;

            while (pReverseDirection ? index < pStartIndex : index >= pEndIndex) {
                Slot slot = this.getSlot(index);
                ItemStack emptyStack = slot.getItem();

                if (emptyStack.isEmpty() && slot.mayPlace(pStack)) {
                    if (pStack.getCount() > slot.getMaxStackSize()) {
                        slot.set(pStack.split(slot.getMaxStackSize()));
                    } else {
                        slot.set(pStack.split(pStack.getCount()));
                    }
                    slot.setChanged();
                    changed = true;
                    break;
                }

                if (pReverseDirection) {
                    index--;
                } else {
                    index++;
                }
            }
        }
        return changed;
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

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
