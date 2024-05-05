package com.elysiumgames.dragoncraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ReturnHomeCommand {
    public ReturnHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes(this::execute)));
    }

    private int execute(CommandContext<CommandSourceStack> pContext) {
        ServerPlayer player = pContext.getSource().getPlayer();
        assert player != null;
        boolean hasHome = player.getPersistentData().getIntArray("dragoncraft.homepos").length != 0;

        if (hasHome) {
            int[] playerPos = player.getPersistentData().getIntArray("dragoncraft.homepos");
            player.teleportTo(playerPos[0], playerPos[1], playerPos[2]);

            pContext.getSource().sendSuccess(() -> Component.literal("Player returned Home!"), false);
            return 1;
        } else {
            pContext.getSource().sendFailure(Component.literal("No Home has been set!"));
            return -1;
        }
    }
}
