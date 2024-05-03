package com.elysiumgames.dragoncraft.datagen.loot;

import com.elysiumgames.dragoncraft.world.item.DCItems;
import com.elysiumgames.dragoncraft.world.level.block.DCBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class DCBlockLootTables extends BlockLootSubProvider {
    public DCBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    private static LootItemCondition.@NotNull Builder getBuilder(RegistryObject<Block> pBlock, IntegerProperty pProperty, int pValue) {
        return LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(pBlock.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(pProperty, pValue));
    }

    private static LootItemCondition.@NotNull Builder getBuilderTall(RegistryObject<Block> pBlock, IntegerProperty pProperty, int pFirstValue, int pSecondValue) {
        return LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(pBlock.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(pProperty, pFirstValue))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(pBlock.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(pProperty, pSecondValue)));
    }

    @Override
    protected void generate() {
        this.dropSelf(DCBlocks.ELATOS_BLOCK.get());
        this.dropSelf(DCBlocks.PARABELLUM_BLOCK.get());
        this.dropSelf(DCBlocks.RAW_PARABELLUM_BLOCK.get());
        this.dropSelf(DCBlocks.BLOOD_RUBY_BLOCK.get());
        this.dropSelf(DCBlocks.INFERNIUM_BLOCK.get());
        this.dropSelf(DCBlocks.DEFAULT_HELL.get());
        this.dropSelf(DCBlocks.JANEMBA_HELL.get());
        this.dropSelf(DCBlocks.GIZARD_DIRT.get());

        this.add(DCBlocks.ELATOS_ORE.get(), block -> createOreDrop(DCBlocks.ELATOS_ORE.get(), DCItems.ELATOS.get()));
        this.add(DCBlocks.DEEPSLATE_ELATOS_ORE.get(), block -> createOreDrop(DCBlocks.DEEPSLATE_ELATOS_ORE.get(), DCItems.ELATOS.get()));
        this.add(DCBlocks.HELL_ELATOS_ORE.get(), block -> createOreDrop(DCBlocks.HELL_ELATOS_ORE.get(), DCItems.ELATOS.get()));
        this.add(DCBlocks.PARABELLUM_ORE.get(), block -> createOreDrop(DCBlocks.PARABELLUM_ORE.get(), DCItems.RAW_PARABELLUM.get()));
        this.add(DCBlocks.DEEPSLATE_PARABELLUM_ORE.get(), block -> createOreDrop(DCBlocks.PARABELLUM_ORE.get(), DCItems.RAW_PARABELLUM.get()));
        this.add(DCBlocks.END_STONE_PARABELLUM_ORE.get(), block -> createOreDrop(DCBlocks.PARABELLUM_ORE.get(), DCItems.RAW_PARABELLUM.get()));
        this.add(DCBlocks.BLOOD_RUBY_ORE.get(), block -> createOreDrop(DCBlocks.BLOOD_RUBY_ORE.get(), DCItems.BLOOD_RUBY.get()));
        this.add(DCBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(), block -> createOreDrop(DCBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(), DCItems.BLOOD_RUBY.get()));
        this.add(DCBlocks.HELL_BLOOD_RUBY_ORE.get(), block -> createOreDrop(DCBlocks.ELATOS_ORE.get(), DCItems.ELATOS.get()));
        this.add(DCBlocks.HELL_INFERNIUM_ORE.get(), block -> createOreDrop(DCBlocks.ELATOS_ORE.get(), DCItems.ELATOS.get()));
    }

    protected LootTable.Builder createManyOreDrops(Block pBlock, Item item, float pMin, float pMax) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(pMin, pMax)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DCBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
