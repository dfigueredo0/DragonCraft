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

public class StatusPointsCommand {
    public StatusPointsCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("SP")
                .then(Commands.argument("player", EntityArgument.player())
                        .then(Commands.literal("add")
                                .then(Commands.argument("amount", DoubleArgumentType.doubleArg())
                                        .executes(this::add)))
                        .then(Commands.literal("set")
                                .then(Commands.argument("amount", DoubleArgumentType.doubleArg())
                                        .executes(this::set)))
                        .then(Commands.literal("remove")
                                .then(Commands.argument("amount", DoubleArgumentType.doubleArg())
                                        .executes(this::remove)))
                        .then(Commands.literal("needed")
                                .then(Commands.argument("amount", DoubleArgumentType.doubleArg())
                                        .executes(this::needed)))));
    }

    private int needed(CommandContext<CommandSourceStack> pContext) {
        Entity entity;
        try {
            entity = EntityArgument.getEntity(pContext, "Player");
        } catch (CommandSyntaxException e) {
            pContext.getSource().sendFailure(Component.translatable("command.dragoncraft.player_get.failed"));
            return -1;
        }

        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).isPresent()) {
            PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseThrow(IllegalStateException::new);
            if (DoubleArgumentType.getDouble(pContext, "amount") <= 0) {
                pContext.getSource().sendFailure(Component.literal("Needed Status Points to level up stats have to be greater than or equal to one!"));
                return -1;
            }
            playerVariables.neededStatPoints = DoubleArgumentType.getDouble(pContext, "amount");
            playerVariables.syncPlayerVariables(entity);
        }
        return 0;
    }

    private int remove(CommandContext<CommandSourceStack> pContext) {
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

            if (playerVariables.statusPoints - amount < 0) {
                pContext.getSource().sendFailure(Component.literal("Status Points cannot be negative!"));
                return -1;
            }

            playerVariables.statusPoints -= amount;
            playerVariables.syncPlayerVariables(entity);

            return 0;
        } else {
            return -1;
        }
    }

    private int add(CommandContext<CommandSourceStack> pContext) {
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
            playerVariables.statusPoints += amount;
            playerVariables.syncPlayerVariables(entity);

            return 0;
        } else {
            return -1;
        }
    }

    private int set(CommandContext<CommandSourceStack> pContext) {
        Entity entity;
        try {
            entity = EntityArgument.getEntity(pContext, "Player");
        } catch (CommandSyntaxException e) {
            pContext.getSource().sendFailure(Component.translatable("command.dragoncraft.player_get.failed"));
            return -1;
        }

        if (entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).isPresent()) {
            PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseThrow(IllegalStateException::new);
            playerVariables.statusPoints = DoubleArgumentType.getDouble(pContext, "amount");
            playerVariables.syncPlayerVariables(entity);

            return 0;
        } else {
            return -1;
        }
    }
}
