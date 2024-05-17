package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;

public class SelectedKiSlotHandler {
    public enum KiSlot {
        SLOT1,
        SLOT2,
        SLOT3,
        SLOT4,
        SLOT5,
        SLOT6,
        SLOT7,
        SLOT8
    }

    public static void execute(Entity entity, KiSlot slot) {
        assert entity != null;

        PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables());

        String slotValue = switch (slot) {
            case SLOT1 -> playerVariables.slot1;
            case SLOT2 -> playerVariables.slot2;
            case SLOT3 -> playerVariables.slot3;
            case SLOT4 -> playerVariables.slot4;
            case SLOT5 -> playerVariables.slot5;
            case SLOT6 -> playerVariables.slot6;
            case SLOT7 -> playerVariables.slot7;
            case SLOT8 -> playerVariables.slot8;
        };

        if (!slotValue.equals("Empty")) {
            boolean isChargingAttack = true;
            entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.isChargingAttack = isChargingAttack;
                capability.currentAttack = slotValue;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
