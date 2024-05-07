package com.elysiumgames.dragoncraft.data.datagen.loot;

import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
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
        this.dropSelf(ModBlocks.ELATOS_BLOCK.get());
        this.dropSelf(ModBlocks.PARABELLUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_PARABELLUM_BLOCK.get());
        this.dropSelf(ModBlocks.BLOOD_RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.INFERNIUM_BLOCK.get());
        this.dropSelf(ModBlocks.DEFAULT_HELL.get());
        this.dropSelf(ModBlocks.JANEMBA_HELL.get());
        this.dropSelf(ModBlocks.GIZARD_DIRT.get());
        this.dropSelf(ModBlocks.AJISA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_AJISA_LOG.get());
        this.dropSelf(ModBlocks.AJISA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_AJISA_WOOD.get());
        this.dropSelf(ModBlocks.AJISA_PLANKS.get());
        this.dropSelf(ModBlocks.AJISA_SAPLING.get());

        this.add(ModBlocks.ELATOS_ORE.get(), block -> createOreDrop(ModBlocks.ELATOS_ORE.get(), ModItems.ELATOS.get()));
        this.add(ModBlocks.DEEPSLATE_ELATOS_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_ELATOS_ORE.get(), ModItems.ELATOS.get()));
        this.add(ModBlocks.HELL_ELATOS_ORE.get(), block -> createOreDrop(ModBlocks.HELL_ELATOS_ORE.get(), ModItems.ELATOS.get()));
        this.add(ModBlocks.PARABELLUM_ORE.get(), block -> createOreDrop(ModBlocks.PARABELLUM_ORE.get(), ModItems.RAW_PARABELLUM.get()));
        this.add(ModBlocks.DEEPSLATE_PARABELLUM_ORE.get(), block -> createOreDrop(ModBlocks.PARABELLUM_ORE.get(), ModItems.RAW_PARABELLUM.get()));
        this.add(ModBlocks.END_STONE_PARABELLUM_ORE.get(), block -> createOreDrop(ModBlocks.PARABELLUM_ORE.get(), ModItems.RAW_PARABELLUM.get()));
        this.add(ModBlocks.BLOOD_RUBY_ORE.get(), block -> createOreDrop(ModBlocks.BLOOD_RUBY_ORE.get(), ModItems.BLOOD_RUBY.get()));
        this.add(ModBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_BLOOD_RUBY_ORE.get(), ModItems.BLOOD_RUBY.get()));
        this.add(ModBlocks.HELL_BLOOD_RUBY_ORE.get(), block -> createOreDrop(ModBlocks.ELATOS_ORE.get(), ModItems.ELATOS.get()));
        this.add(ModBlocks.HELL_INFERNIUM_ORE.get(), block -> createOreDrop(ModBlocks.ELATOS_ORE.get(), ModItems.ELATOS.get()));
        this.add(ModBlocks.AJISA_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.AJISA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.AJISA_SIGN.get(), block -> createSingleItemTable(ModItems.AJISA_SIGN.get()));
        this.add(ModBlocks.AJISA_WALL_SIGN.get(), block -> createSingleItemTable(ModItems.AJISA_SIGN.get()));
        this.add(ModBlocks.AJISA_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.AJISA_HANGING_SIGN.get()));
        this.add(ModBlocks.AJISA_WALL_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.AJISA_HANGING_SIGN.get()));
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
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
