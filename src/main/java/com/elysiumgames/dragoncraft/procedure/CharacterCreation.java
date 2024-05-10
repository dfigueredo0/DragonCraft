package com.elysiumgames.dragoncraft.procedure;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import com.elysiumgames.dragoncraft.world.inventory.StatisticsMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class CharacterCreation {
    public static void execute(LevelAccessor levelAccessor, Entity entity, int x, int y, int z) {
        if (entity == null) {
            return;
        }
        boolean isCharacterCreated = true;
        entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.createdCharacter = isCharacterCreated;
            capability.syncPlayerVariables(entity);
        });
        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).race.equals("Saiyan")) {
            double maxHealth = 200.0D;
            double strength = 60.0D;
            double speed = 120.0D;
            double maxKi = 120.0D;
            double mental = 30.0D;
            double kiPower = 75.0D;
            double zenkaiBoostLevel = 1.0D;
            if (Math.random() < 0.5D) {
                double maxHealthL = maxHealth * 1.5D;
                double strengthL = strength * 1.5D;
                double speedL = speed * 1.5D;
                double maxKiL = maxKi * 1.5D;
                double mentalL = mental * 1.5D;
                double kiPowerL = kiPower * 1.5D;
                double zenkaiBoostLevelL = zenkaiBoostLevel * 10.D;
                entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.isLegendary = true;
                    capability.maxHealth = maxHealthL;
                    capability.strength = strengthL;
                    capability.speed = speedL;
                    capability.maxKi = maxKiL;
                    capability.ki = maxKiL;
                    capability.mental = mentalL;
                    capability.kiPower = kiPowerL;
                    capability.zenkaiBoostLevel = zenkaiBoostLevelL;
                    capability.syncPlayerVariables(entity);

                });
            } else {
                entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.maxHealth = maxHealth;
                    capability.strength = strength;
                    capability.speed = speed;
                    capability.ki = maxKi;
                    capability.mental = mental;
                    capability.kiPower = kiPower;
                    capability.zenkaiBoostLevel = zenkaiBoostLevel;
                    capability.syncPlayerVariables(entity);
                });
            }
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setHealth((float) entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxHealth);
            }
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxStamina = 20; //TODO: NOTICE
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.stamina = capability.maxStamina;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxEndurance = 20;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.endurance = capability.maxEndurance;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof ServerPlayer serverPlayer) {
                final BlockPos blockPos = new BlockPos(x, y, z);
                NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                    @Nullable
                    @Override
                    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
                        return new StatisticsMenu(pContainerId, pPlayerInventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
                    }

                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Stats");
                    }

                }, blockPos);
            }
        }
        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).race.equals("Namekian")) {
            double maxHealth = 600.0D;
            double strength = 10.0D;
            double speed = 200.0D;
            double maxKi = 120.0D;
            double mental = 90.0D;
            double kiPower = 30.0D;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.maxHealth = maxHealth;
                capability.strength = strength;
                capability.speed = speed;
                capability.maxKi = maxKi;
                capability.ki = maxKi;
                capability.mental = mental;
                capability.kiPower = kiPower;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setHealth((float) entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxHealth);
            }
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxStamina = 20; //TODO: NOTICE
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.stamina = capability.maxStamina;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxEndurance = 20;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.endurance = capability.maxEndurance;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof ServerPlayer serverPlayer) {
                final BlockPos blockPos = new BlockPos(x, y, z);
                NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                    @Nullable
                    @Override
                    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
                        return new StatisticsMenu(pContainerId, pPlayerInventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
                    }

                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Stats");
                    }
                }, blockPos);
            }
        }
        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).race.equals("Frost Demon")) {
            double maxHealth = 400.0D;
            double strength = 20.0D;
            double speed = 150.0D;
            double maxKi = 500.0D;
            double mental = 50.0D;
            double kiPower = 100.0D;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.maxHealth = maxHealth;
                capability.strength = strength;
                capability.speed = speed;
                capability.maxKi = maxKi;
                capability.ki = maxKi;
                capability.mental = mental;
                capability.kiPower = kiPower;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setHealth((float) entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxHealth);
            }
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxStamina = 20; //TODO: NOTICE
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.stamina = capability.maxStamina;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxEndurance = 20;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.endurance = capability.maxEndurance;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof ServerPlayer serverPlayer) {
                final BlockPos blockPos = new BlockPos(x, y, z);
                NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                    @Nullable
                    @Override
                    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
                        return new StatisticsMenu(pContainerId, pPlayerInventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
                    }

                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Stats");
                    }
                }, blockPos);
            }
        }
        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).race.equals("Human")) {
            double maxHealth = 380.0D;
            double strength = 20.0D;
            double speed = 90.0D;
            double maxKi = 80.0D;
            double mental = 45.0D;
            double kiPower = 25.0D;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.maxHealth = maxHealth;
                capability.strength = strength;
                capability.speed = speed;
                capability.maxKi = maxKi;
                capability.ki = maxKi;
                capability.mental = mental;
                capability.kiPower = kiPower;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setHealth((float) entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxHealth);
            }
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxStamina = 20; //TODO: NOTICE
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.stamina = capability.maxStamina;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxEndurance = 20;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.endurance = capability.maxEndurance;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof ServerPlayer serverPlayer) {
                final BlockPos blockPos = new BlockPos(x, y, z);
                NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                    @Nullable
                    @Override
                    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
                        return new StatisticsMenu(pContainerId, pPlayerInventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
                    }

                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Stats");
                    }
                }, blockPos);
            }
        }
        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).race.equals("Half-Saiyan")) {
            double maxHealth = 290.0D;
            double strength = 25.0D;
            double speed = 120.0D;
            double maxKi = 150.0D;
            double mental = 50.0D;
            double kiPower = 80.0D;
            double zenkaiBoostLevel = 1.0D;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.maxHealth = maxHealth;
                capability.strength = strength;
                capability.speed = speed;
                capability.maxKi = maxKi;
                capability.ki = maxKi;
                capability.mental = mental;
                capability.kiPower = kiPower;
                capability.zenkaiBoostLevel = 1.0D;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setHealth((float) entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxHealth);
            }
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxStamina = 20; //TODO: NOTICE
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.stamina = capability.maxStamina;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxEndurance = 20;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.endurance = capability.maxEndurance;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof ServerPlayer serverPlayer) {
                final BlockPos blockPos = new BlockPos(x, y, z);
                NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                    @Nullable
                    @Override
                    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
                        return new StatisticsMenu(pContainerId, pPlayerInventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
                    }

                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Stats");
                    }
                }, blockPos);
            }
        }
        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).race.equals("Majin")) {
            double maxHealth = 380.0D; //TODO: Change Values
            double strength = 20.0D;
            double speed = 90.0D;
            double maxKi = 80.0D;
            double mental = 45.0D;
            double kiPower = 25.0D;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.maxHealth = maxHealth;
                capability.strength = strength;
                capability.speed = speed;
                capability.maxKi = maxKi;
                capability.ki = maxKi;
                capability.mental = mental;
                capability.kiPower = kiPower;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setHealth((float) entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxHealth);
            }
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxStamina = 20; //TODO: NOTICE
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.stamina = capability.maxStamina;
                capability.syncPlayerVariables(entity);
            });
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).maxEndurance = 20;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.endurance = capability.maxEndurance;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof ServerPlayer serverPlayer) {
                final BlockPos blockPos = new BlockPos(x, y, z);
                NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                    @Nullable
                    @Override
                    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
                        return new StatisticsMenu(pContainerId, pPlayerInventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(blockPos));
                    }

                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Stats");
                    }
                }, blockPos);
            }
        }
    }
}
