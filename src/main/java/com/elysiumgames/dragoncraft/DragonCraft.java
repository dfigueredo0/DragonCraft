package com.elysiumgames.dragoncraft;

import com.elysiumgames.dragoncraft.client.gui.screens.inventory.AltInventoryScreen;
import com.elysiumgames.dragoncraft.client.renderer.entity.SaibamenRenderer;
import com.elysiumgames.dragoncraft.config.AttributeConfig;
import com.elysiumgames.dragoncraft.fluid.ModFluidTypes;
import com.elysiumgames.dragoncraft.fluid.ModFluids;
import com.elysiumgames.dragoncraft.painting.ModPaintings;
import com.elysiumgames.dragoncraft.sound.ModSounds;
import com.elysiumgames.dragoncraft.utils.ModWoodTypes;
import com.elysiumgames.dragoncraft.world.entity.ModEntities;
import com.elysiumgames.dragoncraft.world.inventory.ModMenuTypes;
import com.elysiumgames.dragoncraft.world.item.ModCreativeModeTab;
import com.elysiumgames.dragoncraft.world.item.ModItemProperties;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.biome.ModTerraBlenderAPI;
import com.elysiumgames.dragoncraft.world.level.biome.surface.ModSurfaceRules;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import com.elysiumgames.dragoncraft.world.level.block.entity.ModBlockEntities;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import terrablender.api.SurfaceRuleManager;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod(DragonCraft.MOD_ID)
public class DragonCraft {
    public static final String PROTOCOL_VERSION = "1.0";
    public static final String MOD_ID = "dragoncraft";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, MOD_ID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
    private static int messageID = 0;

    public DragonCraft() {
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
        ModMenuTypes.register(modEventBus);
        ModEntities.register(modEventBus);
        ModTerraBlenderAPI.registerRegions();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    @SubscribeEvent
    public static void onLoadComplete(FMLLoadCompleteEvent event) {
        AttributeConfig.load(FMLPaths.CONFIGDIR.get().resolve(MOD_ID + ".json").toFile()).applyChanges();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getKey().run());
            workQueue.removeAll(actions);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.AJISA);
            ModItemProperties.addCustomItemProperties();
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_HEALING_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_HEALING_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRAGON_BALL.get(), RenderType.translucent());
            MenuScreens.register(ModMenuTypes.ALT_INVENTORY_MENU.get(), AltInventoryScreen::new);
            EntityRenderers.register(ModEntities.SAIBAMEN.get(), SaibamenRenderer::new);
        }
    }
}
