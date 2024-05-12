package com.elysiumgames.dragoncraft.data.generators;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.utils.IAgeableCropBlock;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DragonCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(ModBlocks.KORIN_PILLAR.get(), new ModelFile.UncheckedModelFile(modLoc("block/korin_pillar")));
        simpleBlock(ModBlocks.KORIN_PILLAR_1.get(), new ModelFile.UncheckedModelFile(modLoc("block/korin_pillar_1")));
        simpleBlock(ModBlocks.KORIN_PILLAR_2.get(), new ModelFile.UncheckedModelFile(modLoc("block/korin_pillar_2")));
        simpleBlock(ModBlocks.DRAGON_BALL.get(), new ModelFile.UncheckedModelFile(modLoc("block/dragon_ball")));

        blockWithItem(ModBlocks.ELATOS_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ELATOS_ORE);
        blockWithItem(ModBlocks.HELL_ELATOS_ORE);
        blockWithItem(ModBlocks.PARABELLUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PARABELLUM_ORE);
        blockWithItem(ModBlocks.END_STONE_PARABELLUM_ORE);
        blockWithItem(ModBlocks.BLOOD_RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_BLOOD_RUBY_ORE);
        blockWithItem(ModBlocks.HELL_BLOOD_RUBY_ORE);
        blockWithItem(ModBlocks.HELL_INFERNIUM_ORE);
        //blockWithItem(DCBlocks.ELATOS_BLOCK); // TODO: Make textures for commented out blocks
        //blockWithItem(DCBlocks.RAW_PARABELLUM_BLOCK);
        //blockWithItem(DCBlocks.PARABELLUM_BLOCK);
        //blockWithItem(DCBlocks.RUBY_BLOCK);
        //blockWithItem(DCBlocks.INFERNIUM_BLOCK);
        //blockWithItem(DCBlocks.KATCHIN_BLOCK);
        blockWithItem(ModBlocks.GIZARD_DIRT);
        blockWithItem(ModBlocks.DEFAULT_HELL);
        blockWithItem(ModBlocks.JANEMBA_HELL);
        blockWithItem(ModBlocks.NAMEK_PORTAL);
        logBlock((RotatedPillarBlock) ModBlocks.AJISA_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.AJISA_WOOD.get(), blockTexture(ModBlocks.AJISA_LOG.get()), blockTexture(ModBlocks.AJISA_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_AJISA_LOG.get(), new ResourceLocation(DragonCraft.MOD_ID, "block/stripped_ajisa_log"), new ResourceLocation(DragonCraft.MOD_ID, "block/stripped_ajisa_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_AJISA_WOOD.get(), new ResourceLocation(DragonCraft.MOD_ID, "block/stripped_ajisa_log"), new ResourceLocation(DragonCraft.MOD_ID, "block/stripped_ajisa_log"));
        blockItem(ModBlocks.AJISA_LOG);
        blockItem(ModBlocks.AJISA_WOOD);
        blockItem(ModBlocks.STRIPPED_AJISA_WOOD);
        blockItem(ModBlocks.STRIPPED_AJISA_LOG);
        leavesBlock(ModBlocks.AJISA_LEAVES);
        blockWithItem(ModBlocks.AJISA_PLANKS);
        saplingBlock(ModBlocks.AJISA_SAPLING);
        signBlock((StandingSignBlock) ModBlocks.AJISA_SIGN.get(), (WallSignBlock) ModBlocks.AJISA_WALL_SIGN.get(), blockTexture(ModBlocks.AJISA_PLANKS.get()));
        hangingSignBlock(ModBlocks.AJISA_HANGING_SIGN.get(), ModBlocks.AJISA_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.AJISA_PLANKS.get()));
    }


    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    private void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        new ResourceLocation("minecraft:block/leaves"), "all",
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(DragonCraft.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock pCropBlock, String modelName, String textureName) {
        if(!(pCropBlock instanceof IAgeableCropBlock cropBlock)) {
            throw new IllegalArgumentException("This crop does not age.");
        }
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue((cropBlock).getAgeProperty()),
                new ResourceLocation(DragonCraft.MOD_ID, "block/" + textureName + state.getValue((cropBlock).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
