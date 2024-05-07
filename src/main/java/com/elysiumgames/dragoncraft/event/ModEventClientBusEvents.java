package com.elysiumgames.dragoncraft.event;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.particle.BeyondSuperSaiyanParticles;
import com.elysiumgames.dragoncraft.particle.ModParticles;
import com.elysiumgames.dragoncraft.world.level.block.entity.ModBlockEntities;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DragonCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        //event.registerSpriteSet(ModParticles.BEYOND_SS_PARTICLES.get(), BeyondSuperSaiyanParticles.Provider::new);
    }

    @SubscribeEvent
    public static void registerBlockEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
