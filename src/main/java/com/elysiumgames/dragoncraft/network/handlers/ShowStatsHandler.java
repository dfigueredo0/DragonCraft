package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.text.DecimalFormat;

public class ShowStatsHandler {
    public enum VariableType {
        HEALTH,
        KI,
        STAMINA,
        POWER,
        ENDURANCE
    }

    public static boolean checkVar(Entity entity, double threshold, VariableType type) {
        assert entity != null;

        PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables());

        double currentVal;
        double maxVal = switch (type) {
            case HEALTH -> {
                currentVal = playerVariables.health;
                yield playerVariables.maxHealth;
            }
            case KI -> {
                currentVal = playerVariables.ki;
                yield playerVariables.maxKi;
            }
            case STAMINA -> {
                currentVal = playerVariables.stamina;
                yield playerVariables.maxStamina;
            }
            case POWER -> {
                currentVal = playerVariables.releasedPower;
                yield 1.0D;
            }
            case ENDURANCE -> {
                currentVal = playerVariables.endurance;
                yield playerVariables.maxEndurance;
            }
            default -> throw new IllegalArgumentException("Unknown VariableType:" + type);
        };
        if (type.equals(VariableType.POWER)) {
            return currentVal >= threshold;
        } else {
            return currentVal >= maxVal * threshold;
        }
    }

    public static String showVar(Entity entity, VariableType type) {
        assert entity != null;

        PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables());

        if (entity instanceof LivingEntity) {
            String varType;
            double value = switch (type) {
                case HEALTH:
                    varType = "Health: ";
                    yield playerVariables.maxHealth;
                case KI:
                    varType = "Ki: ";
                    yield playerVariables.maxKi;
                case STAMINA:
                    varType = "Stamina: ";
                    yield playerVariables.maxStamina;
                case POWER:
                    varType = "PL: ";
                    yield playerVariables.powerLevel;
                default:
                    throw new IllegalArgumentException("Unknown VariableType:" + type);
            };
            if (type.equals(VariableType.POWER)) {
                if (playerVariables.isHighPLOn) {
                    return varType + new DecimalFormat("##").format(-1.0D) + "/" + new DecimalFormat("##").format(value * 100);
                } else {
                    return varType + new DecimalFormat("##").format(-1.0D) + "/" + new DecimalFormat("##").format(value);
                }
            }
            return varType + new DecimalFormat("##").format(-1.0D) + "/" + new DecimalFormat("##").format(value);
        }
        return "";
    }
}
