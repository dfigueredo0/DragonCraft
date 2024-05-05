package com.elysiumgames.dragoncraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.dimension.DimensionDefaults;

import java.util.Optional;

public class BackCommand {
    public BackCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("back").executes(this::execute));
    }

    private int execute(CommandContext<CommandSourceStack> pContext) {
        ServerPlayer player = pContext.getSource().getPlayer();
        assert player != null;
        Optional<GlobalPos> playerLastDeathLocation = player.getLastDeathLocation();

        player.getPersistentData().putIntArray("dragoncraft.playerlastdeathlocation",
                new int[] {playerLastDeathLocation.get().pos().getX(), playerLastDeathLocation.get().pos().getY(), playerLastDeathLocation.get().pos().getZ()});

        int[] playerPos = player.getPersistentData().getIntArray("dragoncraft.playerlastdeathlocation");
        player.teleportTo(playerPos[0], playerPos[1], playerPos[2]);

        pContext.getSource().sendSuccess(() -> Component.literal("Player sent back to last death position!"), false);
        return 1;
    }
}
