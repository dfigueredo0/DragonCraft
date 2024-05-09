package com.elysiumgames.dragoncraft.procedure;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullConsumer;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Supplier;

public class AltInventory {
    public static class Open {
        public static void execute(LevelAccessor levelAccessor, Entity entity) {
            if (entity == null)
                return;
            DragonCraft.queueServerWork(1, () -> {
                if (entity instanceof Player player) {
                    AbstractContainerMenu currentMenu = player.containerMenu;
                    setPlayerSlotItem(currentMenu, entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).topSlot0, 0, player);
                    setPlayerSlotItem(currentMenu, entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).tShirtSlot1, 1, player);
                    setPlayerSlotItem(currentMenu, entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).pantsSlot2, 2, player);
                    setPlayerSlotItem(currentMenu, entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).bootsSlot3, 3, player);
                    setPlayerSlotItem(currentMenu, entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).wristbandSlot4, 4, player);
                    setPlayerSlotItem(currentMenu, entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).beltSlot5, 5, player);
                    setPlayerSlotItem(currentMenu, entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weightSlot6, 6, player);
                    setPlayerSlotItem(currentMenu, entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).scouterSlot7, 6, player);
                }
            });
        }

        private static void setPlayerSlotItem(AbstractContainerMenu currentMenu, ItemStack entity, int key, Player player) {
            if (currentMenu instanceof Supplier supplier) {
                Object result = supplier.get();
                if (result instanceof Map slots) {
                    ItemStack stackToSet = entity;
                    stackToSet.setCount(1);
                    ((Slot) slots.get(key)).set(stackToSet);
                    player.containerMenu.broadcastChanges();
                }
            }
        }
    }

    public static class Close {
        public static void execute(Entity entity) {
            if (entity == null)
                return;
            if (entity instanceof Player) {
                Player player = (Player) entity;
                AbstractContainerMenu menu = player.containerMenu;
                if (menu instanceof Supplier) {
                    Supplier<?> supplier = (Supplier<?>) menu;
                    Object result = supplier.get();
                    if (result instanceof Map) {
                        Map<Integer, Slot> slotMap = (Map<Integer, Slot>) result;
                        for (int i = 0; i <= 7; i++) {  // Assuming loop for 0 to 7 based on bytecode pattern
                            Slot slot = slotMap.get(i);
                            if (slot != null) {
                                ItemStack itemStack = slot.getItem();
                                processItemStack(player, itemStack);
                            }
                        }
                    }
                }
            }
        }

        private static void processItemStack(Player player, ItemStack itemStack) {
            LazyOptional<PlayerStatusVariables.PlayerVariables> itemStackOptional = player.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null);
            itemStackOptional.ifPresent(new NonNullConsumer<PlayerStatusVariables.PlayerVariables>() {
                @Override
                public void accept(PlayerStatusVariables.@NotNull PlayerVariables playerVariables) {

                }
            });
        }
    }

}
