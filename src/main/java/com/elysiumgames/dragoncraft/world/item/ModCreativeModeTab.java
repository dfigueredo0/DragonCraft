package com.elysiumgames.dragoncraft.world.item;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DragonCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DRAGONCRAFT_TAB = CREATIVE_MODE_TABS.register("dragoncraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KATCHIN.get()))
                    .title(Component.translatable("creativetab.dragoncraft_tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.KATCHIN.get());
                        output.accept(ModItems.ELATOS.get());
                        output.accept(ModItems.INFERNIUM.get());
                        output.accept(ModItems.BLOOD_RUBY.get());
                        output.accept(ModItems.RAW_PARABELLUM.get());
                        output.accept(ModItems.PARABELLUM_INGOT.get());

                        output.accept(ModItems.DINOSAUR_MEAT.get());
                        output.accept(ModItems.COOK_DINOSAUR_MEAT.get());
                        output.accept(ModItems.RADISH.get());

                        output.accept(ModItems.BLOOD_RUBY_SWORD.get());
                        output.accept(ModItems.BLOOD_RUBY_SHOVEL.get());
                        output.accept(ModItems.BLOOD_RUBY_PICKAXE.get());
                        output.accept(ModItems.BLOOD_RUBY_AXE.get());
                        output.accept(ModItems.BLOOD_RUBY_HOE.get());
                        output.accept(ModItems.PARABELLUM_SWORD.get());
                        output.accept(ModItems.PARABELLUM_SHOVEL.get());
                        output.accept(ModItems.PARABELLUM_PICKAXE.get());
                        output.accept(ModItems.PARABELLUM_AXE.get());
                        output.accept(ModItems.PARABELLUM_HOE.get());
                        output.accept(ModItems.INFERNIUM_SWORD.get());
                        output.accept(ModItems.INFERNIUM_SHOVEL.get());
                        output.accept(ModItems.INFERNIUM_PICKAXE.get());
                        output.accept(ModItems.INFERNIUM_AXE.get());
                        output.accept(ModItems.INFERNIUM_HOE.get());

                        output.accept(ModItems.INFERNIUM_BOW.get());

                        output.accept(ModItems.HEALING_WATER_BUCKET.get());

                        output.accept(ModItems.BLOOD_RUBY_HELMET.get());
                        output.accept(ModItems.BLOOD_RUBY_CHESTPLATE.get());
                        output.accept(ModItems.BLOOD_RUBY_LEGGINGS.get());
                        output.accept(ModItems.BLOOD_RUBY_BOOTS.get());
                        output.accept(ModItems.PARABELLUM_HELMET.get());
                        output.accept(ModItems.PARABELLUM_CHESTPLATE.get());
                        output.accept(ModItems.PARABELLUM_LEGGINGS.get());
                        output.accept(ModItems.PARABELLUM_BOOTS.get());
                        output.accept(ModItems.INFERNIUM_HELMET.get());
                        output.accept(ModItems.INFERNIUM_CHESTPLATE.get());
                        output.accept(ModItems.INFERNIUM_LEGGINGS.get());
                        output.accept(ModItems.INFERNIUM_BOOTS.get());

                        output.accept(ModItems.CHA_LA_RECORD.get());
                        output.accept(ModItems.CHOZETSU_DYNAMIC_RECORD.get());
                        output.accept(ModItems.DRAGON_SOUL_RECORD.get());
                        output.accept(ModItems.MAKAFUSHIGI_ADVENTURE_RECORD.get());

                        output.accept(ModBlocks.JANEMBA_HELL.get());
                        output.accept(ModBlocks.DEFAULT_HELL.get());
                        output.accept(ModBlocks.GIZARD_DIRT.get());
                        output.accept(ModBlocks.KATCHIN_BLOCK.get());
                        output.accept(ModBlocks.ELATOS_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ELATOS_ORE.get());
                        output.accept(ModBlocks.HELL_ELATOS_ORE.get());
                        output.accept(ModBlocks.BLOOD_RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get());
                        output.accept(ModBlocks.HELL_BLOOD_RUBY_ORE.get());
                        output.accept(ModBlocks.HELL_INFERNIUM_ORE.get());
                        output.accept(ModBlocks.PARABELLUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_PARABELLUM_ORE.get());
                        output.accept(ModBlocks.END_STONE_PARABELLUM_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
