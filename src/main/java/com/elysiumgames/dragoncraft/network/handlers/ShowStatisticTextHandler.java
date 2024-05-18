package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;

import java.text.DecimalFormat;

public class ShowStatisticTextHandler {
    public enum Type {
        KI_DMG,
        CUR_DEF,
        MELEE,
        KI_POWER,
        SPEED,
        STRENGTH,
        DEFENSE,
        MAX_STAMINA,
        MAX_KI,
        MAX_HEALTH,
        ALIGNMENT,
        CLASS,
        FORM,
        BASE,
        STATUS_POINTS,
        RELEASED_POWER
    }

    public static String showVar(Entity entity, Type type) {
        assert entity != null;

        PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables());

        String varType = "";
        double value = 0;
        String val = "";
        switch (type) {
            case MELEE -> {
                varType = "Melee Damage: ";
                value = playerVariables.meleeDamage;
            }
            case SPEED -> {
                varType = "Speed: ";
                value = playerVariables.speed;
            }
            case KI_DMG -> {
                varType = "Ki Damage: ";
                value = playerVariables.kiDamage;
            }
            case MAX_KI -> {
                varType = "Max Ki: ";
                value = playerVariables.maxKi;
            }
            case CUR_DEF -> {
                varType = "Current Defense: ";
                value = playerVariables.currentDefense;
            }
            case DEFENSE -> {
                varType = "Max Defense: ";
                value = playerVariables.defense;
            }
            case KI_POWER -> {
                varType = "Ki Power: ";
                value = playerVariables.kiPower;
            }
            case STRENGTH -> {
                varType = "Strength: ";
                value = playerVariables.strength;
            }
            case MAX_HEALTH -> {
                varType = "Max Health: ";
                value = playerVariables.maxHealth;
            }
            case MAX_STAMINA -> {
                varType = "Max Stamina: ";
                value = playerVariables.maxStamina;
            }
            case ALIGNMENT -> {
                varType = "Alignment: ";
                val = playerVariables.alignment;
            }
            case CLASS -> {
                varType = "Class: ";
                val = playerVariables.fightingClass;
            }
            case BASE -> {
                varType = "Base Form: ";
                val = playerVariables.subForm;
            }
            case FORM -> {
                varType = "Form: ";
                val = playerVariables.form;
            }
            case STATUS_POINTS -> {
                varType = "Status Points: ";
                value = playerVariables.statusPoints;
            }
            case RELEASED_POWER -> {
                value = playerVariables.releasedPower * 100.0D;
            }

            default -> throw new IllegalArgumentException("Unknown Type: " + type);
        }
        if (isString(type)) {
            return varType + val;
        } else if (type.equals(Type.STATUS_POINTS)) {
            return varType + new DecimalFormat("##").format(value) + "/" + new DecimalFormat("##").format(playerVariables.neededStatPoints);
        } else if (type.equals(Type.RELEASED_POWER)) {
            return new DecimalFormat("##").format(value) + "%";
        } else {
            return varType + new DecimalFormat("##").format(value);
        }
    }

    private static boolean isString(Type type) {
        return type.equals(Type.ALIGNMENT) || type.equals(Type.CLASS) || type.equals(Type.BASE) || type.equals(Type.FORM);
    }
}
