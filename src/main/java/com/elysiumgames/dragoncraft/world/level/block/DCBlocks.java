package com.elysiumgames.dragoncraft.world.level.block;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.item.DCItems;
import com.elysiumgames.dragoncraft.world.level.block.custom.ClimbablePillarBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DCBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DragonCraft.MOD_ID);

    //Ores
    public static final RegistryObject<Block> ELATOS_ORE = registerBlock("elatos_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_ELATOS_ORE = registerBlock("deepslate_elatos_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final RegistryObject<Block> HELL_ELATOS_ORE = registerBlock("hell_elatos_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)));
    public static final RegistryObject<Block> PARABELLUM_ORE = registerBlock("parabellum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_PARABELLUM_ORE = registerBlock("deepslate_parabellum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> END_STONE_PARABELLUM_ORE = registerBlock("end_stone_parabellum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));
    public static final RegistryObject<Block> HELL_RUBY_ORE = registerBlock("hell_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));
    public static final RegistryObject<Block> HELL_INFERNIUM_ORE = registerBlock("hell_infernium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)));

    //Biome Blocks
    public static final RegistryObject<Block> GIZARD_DIRT = registerBlock("gizard_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> DEFAULT_HELL = registerBlock("default_hell",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> JANEMBA_HELL = registerBlock("janemba_hell",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    //Others
    public static final RegistryObject<Block> KATCHIN_BLOCK = registerBlock("katchin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));

    //Korin Tower TODO: Make Climbable
    public static final RegistryObject<Block> KORIN_PILLAR = registerBlock("korin_pillar",
            () -> new ClimbablePillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable().noOcclusion()
                    .strength(-1F, 65536).emissiveRendering((blockState, blockGetter, blockPos) -> false)));
    public static final RegistryObject<Block> KORIN_PILLAR_1  = registerBlock("korin_pillar_1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable().noOcclusion().noLootTable().noOcclusion()
                    .strength(-1F, 65536).emissiveRendering((blockState, blockGetter, blockPos) -> false)));
    public static final RegistryObject<Block> KORIN_PILLAR_2  = registerBlock("korin_pillar_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable().noOcclusion().noLootTable().noOcclusion()
                    .strength(-1F, 65536).emissiveRendering((blockState, blockGetter, blockPos) -> false)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return DCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
