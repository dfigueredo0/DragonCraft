package com.elysiumgames.dragoncraft;

import com.elysiumgames.dragoncraft.fluid.ModFluidTypes;
import com.elysiumgames.dragoncraft.fluid.ModFluids;
import com.elysiumgames.dragoncraft.painting.ModPaintings;
import com.elysiumgames.dragoncraft.particle.ModParticles;
import com.elysiumgames.dragoncraft.sound.ModSounds;
import com.elysiumgames.dragoncraft.utils.ModWoodTypes;
import com.elysiumgames.dragoncraft.world.item.ModCreativeModeTab;
import com.elysiumgames.dragoncraft.world.item.ModItemProperties;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.biome.ModTerraBlenderAPI;
import com.elysiumgames.dragoncraft.world.level.biome.surface.ModSurfaceRules;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import com.elysiumgames.dragoncraft.world.level.block.entity.ModBlockEntities;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DragonCraft.MOD_ID)
public class DragonCraft
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "dragoncraft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public DragonCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTab.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);
        ModPaintings.register(modEventBus);
        //ModParticles.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModTerraBlenderAPI.registerRegions();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(ModWoodTypes.AJISA);
            ModItemProperties.addCustomItemProperties();
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_HEALING_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_HEALING_WATER.get(), RenderType.translucent());
        }
    }
}
