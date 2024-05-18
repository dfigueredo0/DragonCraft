package com.elysiumgames.dragoncraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class BackCommand {
    public BackCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("back").executes(this::execute));
    }

    private int execute(CommandContext<CommandSourceStack> pContext) {
        ServerPlayer player = pContext.getSource().getPlayer();
        assert player != null;

        Optional<GlobalPos> playerLastDeathLocation = player.getLastDeathLocation();

        if (playerLastDeathLocation.isPresent()) {
            GlobalPos deathLocation = playerLastDeathLocation.get();

            if (deathLocation.dimension().equals(Level.OVERWORLD)) {
                int[] deathPos = new int[]{
                        deathLocation.pos().getX(),
                        deathLocation.pos().getY(),
                        deathLocation.pos().getZ()
                };
                player.getPersistentData().putIntArray("dragoncraft.playerlastdeathlocation", deathPos);
                player.teleportTo(deathPos[0], deathPos[1], deathPos[2]);

                pContext.getSource().sendSuccess(() -> Component.literal("Player sent back to last death position!"), false);
                return 0;
            } else {
                pContext.getSource().sendFailure(Component.literal("You must be in the Overworld to use this command!"));
                return -1;
            }
        } else {
            pContext.getSource().sendFailure(Component.literal("No death location recorded!"));
            return -1;
        }
    }
}
