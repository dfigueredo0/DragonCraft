package com.elysiumgames.dragoncraft.command;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

public class StatsCommand {
    public StatsCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("stats")
                .then(Commands.argument("player", EntityArgument.player())
                        .then(Commands.literal("add")
                                .then(Commands.literal("health").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeAddHealth)))
                                .then(Commands.literal("ki").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeAddKi)))
                                .then(Commands.literal("stamina").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeAddStamina)))
                                .then(Commands.literal("strength").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeAddStrength)))
                                .then(Commands.literal("dexterity").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeAddDexterity)))
                                .then(Commands.literal("kiPower").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeAddKiPower))))
                        .then(Commands.literal("set")
                                .then(Commands.literal("health").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeSetHealth)))
                                .then(Commands.literal("ki").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeSetKi)))
                                .then(Commands.literal("stamina").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeSetStamina)))
                                .then(Commands.literal("strength").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeSetStrength)))
                                .then(Commands.literal("dexterity").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeSetDexterity)))
                                .then(Commands.literal("kiPower").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(this::executeSetKiPower))))));
    }

    private int executeSetKiPower(CommandContext<CommandSourceStack> context) {
        return setStat(context, "kiPower");
    }

    private int executeSetDexterity(CommandContext<CommandSourceStack> context) {
        return setStat(context, "dexterity");
    }

    private int executeSetStrength(CommandContext<CommandSourceStack> context) {
        return setStat(context, "strength");
    }

    private int executeSetStamina(CommandContext<CommandSourceStack> context) {
        return setStat(context, "stamina");
    }

    private int executeSetKi(CommandContext<CommandSourceStack> context) {
        return setStat(context, "ki");
    }

    private int executeSetHealth(CommandContext<CommandSourceStack> context) {
        return setStat(context, "health");
    }

    private int executeAddKiPower(CommandContext<CommandSourceStack> context) {
        return addStat(context, "kiPower");
    }

    private int executeAddDexterity(CommandContext<CommandSourceStack> context) {
        return addStat(context, "dexterity");
    }

    private int executeAddStrength(CommandContext<CommandSourceStack> context) {
        return addStat(context, "strength");
    }

    private int executeAddStamina(CommandContext<CommandSourceStack> context) {
        return addStat(context, "stamina");
    }

    private int executeAddKi(CommandContext<CommandSourceStack> context) {
        return addStat(context, "ki");
    }

    private int executeAddHealth(CommandContext<CommandSourceStack> context) {
        return addStat(context, "health");
    }

    private int addStat(CommandContext<CommandSourceStack> pContext, String stat) {
        Entity entity;
        try {
            entity = EntityArgument.getEntity(pContext, "Player");
        } catch (CommandSyntaxException e) {
            pContext.getSource().sendFailure(Component.translatable("command.dragoncraft.player_get.failed"));
            return -1;
        }

        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).isPresent()) {
            PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseThrow(IllegalStateException::new);
            double amount = DoubleArgumentType.getDouble(pContext, "amount");

            switch (stat) {
                case "health":
                    playerVariables.health += amount; //TODO: CON?
                    break;
                case "ki":
                    playerVariables.ki += amount;
                    break;
                case "stamina":
                    playerVariables.stamina += amount;
                    break;
                case "strength":
                    playerVariables.strength += amount;
                    break;
                case "dexterity":
                    playerVariables.speed += amount; //TODO: DEX
                    break;
                case "kiPower":
                    playerVariables.kiPower += amount;
                    break;
            }

            playerVariables.syncPlayerVariables(entity);
            return 0;
        } else {
            return -1;
        }
    }

    private int setStat(CommandContext<CommandSourceStack> pContext, String stat) {
        Entity entity;
        try {
            entity = EntityArgument.getEntity(pContext, "Player");
        } catch (CommandSyntaxException e) {
            pContext.getSource().sendFailure(Component.translatable("command.dragoncraft.player_get.failed"));
            return -1;
        }

        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).isPresent()) {
            PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseThrow(IllegalStateException::new);
            double amount = DoubleArgumentType.getDouble(pContext, "amount");

            switch (stat) {
                case "health":
                    playerVariables.maxHealth = amount; //TODO: CON?
                    break;
                case "ki":
                    playerVariables.maxKi = amount;
                    playerVariables.mental = amount; //TODO: add case
                    break;
                case "stamina":
                    playerVariables.maxStamina = amount;
                    break;
                case "strength":
                    playerVariables.strength = amount;
                    break;
                case "dexterity":
                    playerVariables.speed = amount; //TODO: DEX
                    break;
                case "kiPower":
                    playerVariables.kiPower = amount;
                    break;
            }

            playerVariables.syncPlayerVariables(entity);
            return 0;
        } else {
            return -1;
        }
    }
}
