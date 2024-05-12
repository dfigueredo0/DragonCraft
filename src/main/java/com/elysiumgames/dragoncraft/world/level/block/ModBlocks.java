package com.elysiumgames.dragoncraft.world.level.block;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.fluid.ModFluids;
import com.elysiumgames.dragoncraft.utils.ModWoodTypes;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.block.custom.*;
import com.elysiumgames.dragoncraft.world.level.block.grower.AjisaTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    //Blocks
    public static final RegistryObject<Block> GIZARD_DIRT = registerBlock("gizard_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> DEFAULT_HELL = registerBlock("default_hell",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> JANEMBA_HELL = registerBlock("janemba_hell",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> KATCHIN_BLOCK = registerBlock("katchin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).noLootTable()));
    public static final RegistryObject<Block> AJISA_LOG = registerBlock("ajisa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> AJISA_WOOD = registerBlock("ajisa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_AJISA_LOG = registerBlock("stripped_ajisa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_AJISA_WOOD = registerBlock("stripped_ajisa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> AJISA_PLANKS = registerBlock("ajisa_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> AJISA_LEAVES = registerBlock("ajisa_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> AJISA_SAPLING = registerBlock("ajisa_sapling",
            () -> new SaplingBlock(new AjisaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> AJISA_SIGN = BLOCKS.register("ajisa_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.AJISA));
    public static final RegistryObject<Block> AJISA_WALL_SIGN = BLOCKS.register("ajisa_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.AJISA));
    public static final RegistryObject<Block> AJISA_HANGING_SIGN = BLOCKS.register("ajisa_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.AJISA));
    public static final RegistryObject<Block> AJISA_WALL_HANGING_SIGN = BLOCKS.register("ajisa_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.AJISA));

    public static final RegistryObject<Block> NAMEK_PORTAL = registerBlock("namek_portal", () -> new NamekPortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noLootTable()));

    //Fluids
    public static final RegistryObject<LiquidBlock> HEALING_WATER_BLOCK = BLOCKS.register("healing_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_HEALING_WATER, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

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

    public static final RegistryObject<Block> DRAGON_BALL = registerDragonBlock("dragon_ball",
            () -> new DragonBallBlock(BlockBehaviour.Properties.of().noOcclusion().instabreak().isViewBlocking(ModBlocks::never)));

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerDragonBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerDragonBallBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerDragonBallBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(7).fireResistant().rarity(Rarity.RARE)));
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
