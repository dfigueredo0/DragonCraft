package com.elysiumgames.dragoncraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class SetHomeCommand {
    public SetHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("set")).executes(this::execute));
    }

    private int execute(CommandContext<CommandSourceStack> pContext) {
        ServerPlayer player = pContext.getSource().getPlayer();
        assert player != null;
        BlockPos playerPos = player.blockPosition();
        String positionString = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";

        player.getPersistentData().putIntArray("dragoncraft.homepos",
                new int[] { playerPos.getX(), playerPos.getY(), playerPos.getZ()});

        pContext.getSource().sendSuccess(() -> Component.literal("Set Home at " + positionString), true);
        return 1;
    }
}
