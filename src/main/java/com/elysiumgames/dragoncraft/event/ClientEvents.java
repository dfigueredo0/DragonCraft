package com.elysiumgames.dragoncraft.event;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.client.ModKeyMappings;
import com.elysiumgames.dragoncraft.world.level.block.entity.ModBlockEntities;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = DragonCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            //event.registerSpriteSet(ModParticles.BEYOND_SS_PARTICLES.get(), BeyondSuperSaiyanParticles.Provider::new);
        }

        @SubscribeEvent
        public static void registerBlockEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        }

        @SubscribeEvent
        public static void registerKeys(RegisterKeyMappingsEvent event) {
            event.register(ModKeyMappings.ALT_FUNCTION_KEY);
            event.register(ModKeyMappings.BLOCK_KEY);
            event.register(ModKeyMappings.CHARGING_KEY);
            event.register(ModKeyMappings.FLYING_KEY);
            event.register(ModKeyMappings.JUMP_KEY);
            event.register(ModKeyMappings.KI_ATTACK_KEY);
            event.register(ModKeyMappings.LOCKED_ON_KEY);
            event.register(ModKeyMappings.OPEN_STATS_KEY);
            event.register(ModKeyMappings.RELEASE_POWER_KEY);
            event.register(ModKeyMappings.REVERT_FORM_KEY);
            event.register(ModKeyMappings.TRANSFORM_KEY);
            event.register(ModKeyMappings.TURBO_KEY);
        }
    }
}
