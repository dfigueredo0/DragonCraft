package com.elysiumgames.dragoncraft.world.inventory;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Map;
import java.util.function.Supplier;

// TODO: This entire class
public class RacialSkillMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>>  {
    public RacialSkillMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), extraData);
    }

    public RacialSkillMenu(int pContainerId, Inventory inv, BlockEntity entity, FriendlyByteBuf extraData) {
        super(ModMenuTypes.RACIAL_SKILL_MENU.get(), pContainerId);
    }

    @Override
    public Map<Integer, Slot> get() {
        return Map.of();
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }
}
