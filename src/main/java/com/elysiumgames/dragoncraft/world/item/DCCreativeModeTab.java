package com.elysiumgames.dragoncraft.world.item;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.level.block.DCBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DCCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DragonCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DRAGONCRAFT_TAB = CREATIVE_MODE_TABS.register("dragoncraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DCItems.KATCHIN.get()))
                    .title(Component.translatable("creativetab.dragoncraft_tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(DCItems.KATCHIN.get());
                        output.accept(DCItems.ELATOS.get());
                        output.accept(DCItems.INFERNIUM.get());
                        output.accept(DCItems.BLOOD_RUBY.get());
                        output.accept(DCItems.RAW_PARABELLUM.get());
                        output.accept(DCItems.PARABELLUM_INGOT.get());

                        output.accept(DCItems.DINOSAUR_MEAT.get());
                        output.accept(DCItems.COOK_DINOSAUR_MEAT.get());
                        output.accept(DCItems.RADISH.get());

                        output.accept(DCItems.BLOOD_RUBY_SWORD.get());
                        output.accept(DCItems.BLOOD_RUBY_SHOVEL.get());
                        output.accept(DCItems.BLOOD_RUBY_PICKAXE.get());
                        output.accept(DCItems.BLOOD_RUBY_AXE.get());
                        output.accept(DCItems.BLOOD_RUBY_HOE.get());
                        output.accept(DCItems.PARABELLUM_SWORD.get());
                        output.accept(DCItems.PARABELLUM_SHOVEL.get());
                        output.accept(DCItems.PARABELLUM_PICKAXE.get());
                        output.accept(DCItems.PARABELLUM_AXE.get());
                        output.accept(DCItems.PARABELLUM_HOE.get());
                        output.accept(DCItems.INFERNIUM_SWORD.get());
                        output.accept(DCItems.INFERNIUM_SHOVEL.get());
                        output.accept(DCItems.INFERNIUM_PICKAXE.get());
                        output.accept(DCItems.INFERNIUM_AXE.get());
                        output.accept(DCItems.INFERNIUM_HOE.get());

                        output.accept(DCBlocks.JANEMBA_HELL.get());
                        output.accept(DCBlocks.DEFAULT_HELL.get());
                        output.accept(DCBlocks.GIZARD_DIRT.get());
                        output.accept(DCBlocks.KATCHIN_BLOCK.get());
                        output.accept(DCBlocks.ELATOS_ORE.get());
                        output.accept(DCBlocks.DEEPSLATE_ELATOS_ORE.get());
                        output.accept(DCBlocks.HELL_ELATOS_ORE.get());
                        output.accept(DCBlocks.BLOOD_RUBY_ORE.get());
                        output.accept(DCBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get());
                        output.accept(DCBlocks.HELL_BLOOD_RUBY_ORE.get());
                        output.accept(DCBlocks.HELL_INFERNIUM_ORE.get());
                        output.accept(DCBlocks.PARABELLUM_ORE.get());
                        output.accept(DCBlocks.DEEPSLATE_PARABELLUM_ORE.get());
                        output.accept(DCBlocks.END_STONE_PARABELLUM_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
