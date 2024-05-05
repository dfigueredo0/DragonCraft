package com.elysiumgames.dragoncraft.world.level.block;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.fluid.ModFluids;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.block.custom.ClimbablePillarBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DragonCraft.MOD_ID);

    //Ores
    public static final RegistryObject<Block> ELATOS_ORE = registerBlock("elatos_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> DEEPSLATE_ELATOS_ORE = registerBlock("deepslate_elatos_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).requiresCorrectToolForDrops(), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> HELL_ELATOS_ORE = registerBlock("hell_elatos_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> PARABELLUM_ORE = registerBlock("parabellum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_PARABELLUM_ORE = registerBlock("deepslate_parabellum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> END_STONE_PARABELLUM_ORE = registerBlock("end_stone_parabellum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLOOD_RUBY_ORE = registerBlock("blood_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_BLOOD_RUBY_ORE = registerBlock("deepslate_blood_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> HELL_BLOOD_RUBY_ORE = registerBlock("hell_blood_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> HELL_INFERNIUM_ORE = registerBlock("hell_infernium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    //Block of Ores
    public static final RegistryObject<Block> ELATOS_BLOCK = registerBlock("elatos_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PARABELLUM_BLOCK = registerBlock("parabellum_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> RAW_PARABELLUM_BLOCK = registerBlock("raw_parabellum_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> BLOOD_RUBY_BLOCK = registerBlock("blood_ruby_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> INFERNIUM_BLOCK = registerBlock("infernium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    //Biome Blocks
    public static final RegistryObject<Block> GIZARD_DIRT = registerBlock("gizard_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> DEFAULT_HELL = registerBlock("default_hell",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> JANEMBA_HELL = registerBlock("janemba_hell",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    //Fluids
    public static final RegistryObject<LiquidBlock> HEALING_WATER_BLOCK = BLOCKS.register("healing_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_HEALING_WATER, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    //Others
    public static final RegistryObject<Block> KATCHIN_BLOCK = registerBlock("katchin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).noLootTable()));

    //Korin Tower TODO: Make Climbable
    public static final RegistryObject<Block> KORIN_PILLAR = registerBlock("korin_pillar",
            () -> new ClimbablePillarBlock(BlockBehaviour.Properties.of().noLootTable().noOcclusion().pushReaction(PushReaction.DESTROY)
                    .strength(-1.0F, 1024.0F).emissiveRendering((blockState, blockGetter, blockPos) -> true)));
    public static final RegistryObject<Block> KORIN_PILLAR_1  = registerBlock("korin_pillar_1",
            () -> new ClimbablePillarBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).noLootTable().noOcclusion().noLootTable()
                    .strength(-1.0F, 1024.0F).emissiveRendering((blockState, blockGetter, blockPos) -> true)));
    public static final RegistryObject<Block> KORIN_PILLAR_2  = registerBlock("korin_pillar_2",
            () -> new ClimbablePillarBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).noLootTable().noOcclusion().noLootTable()
                    .strength(-1.0F, 1024.0F).emissiveRendering((blockState, blockGetter, blockPos) -> true)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
