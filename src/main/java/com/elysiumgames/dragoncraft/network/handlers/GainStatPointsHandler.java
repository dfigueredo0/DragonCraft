package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import com.elysiumgames.dragoncraft.world.dimension.ModDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GainStatPointsHandler {
    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity != null) {
            execute(event, livingEntity, event.getSource().getEntity());
        }
    }

    public static void execute(Entity entity, Entity sourceEntity) {
        execute(null, entity, sourceEntity);
    }

    private static void execute(@Nullable Event event, Entity entity, Entity sourceEntity) {
        if (entity == null || sourceEntity == null) return;
        if (entity.level().dimension().equals(ModDimensions.HTC_LEVEL_KEY) && sourceEntity instanceof Player) {
            if (Math.random() < 0.275D) {
                double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weights + 120.0D;
                sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.statusPoints = statusPoints;
                    capability.syncPlayerVariables(sourceEntity);
                });
            } else if (Math.random() < 0.5D) {
                double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weights + 60.0D;
                sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.statusPoints = statusPoints;
                    capability.syncPlayerVariables(sourceEntity);
                });

            } else if (Math.random() < 0.675D) {
                double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weights + 30.0D;
                sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.statusPoints = statusPoints;
                    capability.syncPlayerVariables(sourceEntity);
                });
            } else if (Math.random() < 0.85D) {
                double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weights + 12.0D;
                sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.statusPoints = statusPoints;
                    capability.syncPlayerVariables(sourceEntity);
                });
            }
            if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).race.equals("Human")) {
                if (Math.random() < 0.325D) {
                    double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + 140.0D;
                    sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.statusPoints = statusPoints;
                        capability.syncPlayerVariables(sourceEntity);
                    });
                } else if (Math.random() < 0.55D) {
                    double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + 65.0D;
                    sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.statusPoints = statusPoints;
                        capability.syncPlayerVariables(sourceEntity);
                    });
                } else if (Math.random() < 0.7D) {
                    double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + 28.0D;
                    sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.statusPoints = statusPoints;
                        capability.syncPlayerVariables(sourceEntity);
                    });
                } else if (Math.random() < 0.85D) {
                    double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + 22.0D;
                    sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.statusPoints = statusPoints;
                        capability.syncPlayerVariables(sourceEntity);
                    });
                }
            }
        } else if (!entity.level().dimension().equals(ModDimensions.HTC_LEVEL_KEY) && sourceEntity instanceof Player) {
            if (Math.random() < 0.15D) {
                double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weights + 20.0D;
                sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.statusPoints = statusPoints;
                    capability.syncPlayerVariables(sourceEntity);
                });
            } else if (Math.random() < 0.4D) {
                double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weights + 12.0D;
                sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.statusPoints = statusPoints;
                    capability.syncPlayerVariables(sourceEntity);
                });
            } else if (Math.random() < 0.5D) {
                double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weights + 7.0D;
                sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.statusPoints = statusPoints;
                    capability.syncPlayerVariables(sourceEntity);
                });
            } else if (Math.random() < 0.7D) {
                double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).weights + 3.0D;
                sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.statusPoints = statusPoints;
                    capability.syncPlayerVariables(sourceEntity);
                });
            }
            if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).race.equals("Human")) {
                if (Math.random() < 0.15D) {
                    double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + 50.0D;
                    sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.statusPoints = statusPoints;
                        capability.syncPlayerVariables(sourceEntity);
                    });

                } else if (Math.random() < 0.4D) {
                    double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + 20.0D;
                    sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.statusPoints = statusPoints;
                        capability.syncPlayerVariables(sourceEntity);
                    });
                } else if (Math.random() < 0.5D) {
                    double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + 18.0D;
                    sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.statusPoints = statusPoints;
                        capability.syncPlayerVariables(sourceEntity);
                    });
                } else if (Math.random() < 0.7D) {
                    double statusPoints = sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables()).statusPoints + 8.0D;
                    sourceEntity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.statusPoints = statusPoints;
                        capability.syncPlayerVariables(sourceEntity);
                    });
                }
            }
        }
    }
}