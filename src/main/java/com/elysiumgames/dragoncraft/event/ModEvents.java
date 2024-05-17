package com.elysiumgames.dragoncraft.event;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.client.gui.screens.WelcomeScreen;
import com.elysiumgames.dragoncraft.command.BackCommand;
import com.elysiumgames.dragoncraft.command.ReturnHomeCommand;
import com.elysiumgames.dragoncraft.command.SetHomeCommand;
import com.elysiumgames.dragoncraft.network.ClientHooks;
import com.elysiumgames.dragoncraft.network.handlers.CharacterCreationHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = DragonCraft.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());
        new BackCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        assert event.getEntity() != null;

        if (!CharacterCreationHandler.isCharacterCreated(event.getEntity()) && event.getEntity() instanceof ServerPlayer serverPlayer) {
            final BlockPos blockPos = new BlockPos((int) serverPlayer.getX(), (int) serverPlayer.getY(), (int) serverPlayer.getZ());
            ClientHooks.openScreen(new WelcomeScreen(blockPos));
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getEntity().getPersistentData().putIntArray("dragoncraft.homepos",
                event.getOriginal().getPersistentData().getIntArray("dragoncraft.homepos"));

        event.getEntity().getPersistentData().putIntArray("dragoncraft.playerlastdeathlocation",
                event.getOriginal().getPersistentData().getIntArray("dragoncraft.playerlastdeathlocation"));
    }
}
