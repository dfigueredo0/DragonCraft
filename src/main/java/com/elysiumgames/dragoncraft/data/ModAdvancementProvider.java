package com.elysiumgames.dragoncraft.data;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider pProvider, Consumer<Advancement> pConsumer, ExistingFileHelper pExistingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.BLOOD_RUBY.get()),
                        Component.literal("Dragon Craft"), Component.literal("Dragon Ball Z"),
                        new ResourceLocation(DragonCraft.MOD_ID, "textures/block/janemba_hell.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("created_character", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BLOOD_RUBY.get())) /* TODO: have to create own TriggerInstance for race character creation*/
                .save(pConsumer, new ResourceLocation(DragonCraft.MOD_ID, "dragoncraft"), pExistingFileHelper);
        Advancement summonedShenron = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.BLOOD_RUBY.get()),
                        Component.literal("Summon Shenron the Eternal Dragon"), Component.literal("I Wish for the World's Most Comfortable Pair of Ultra-soft Underwear"),
                        null, FrameType.TASK, true, true, false))
                .parent(rootAdvancement)
                .addCriterion("summoned_shenron", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(EntityType.WITHER))) // TODO: Change to Shenron when possible
                .save(pConsumer, new ResourceLocation(DragonCraft.MOD_ID, "summoned_shenron"), pExistingFileHelper);
    }
}
