package com.elysiumgames.dragoncraft.data.generators;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DragonCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        complexBlock(ModBlocks.KORIN_PILLAR.get());
        complexBlock(ModBlocks.KORIN_PILLAR_1.get());
        complexBlock(ModBlocks.KORIN_PILLAR_2.get());
        complexBlock(ModBlocks.DRAGON_BALL.get());

        simpleItem(ModItems.ELATOS);
        simpleItem(ModItems.RAW_PARABELLUM);
        simpleItem(ModItems.PARABELLUM_INGOT);
        simpleItem(ModItems.BLOOD_RUBY);
        simpleItem(ModItems.INFERNIUM);
        simpleItem(ModItems.KATCHIN);
        simpleItem(ModItems.DINOSAUR_MEAT);
        simpleItem(ModItems.COOK_DINOSAUR_MEAT);
        simpleItem(ModItems.RADISH);

        handheldItem(ModItems.BLOOD_RUBY_SWORD);
        handheldItem(ModItems.BLOOD_RUBY_SHOVEL);
        handheldItem(ModItems.BLOOD_RUBY_PICKAXE);
        handheldItem(ModItems.BLOOD_RUBY_AXE);
        handheldItem(ModItems.BLOOD_RUBY_HOE);
        handheldItem(ModItems.PARABELLUM_SWORD);
        handheldItem(ModItems.PARABELLUM_SHOVEL);
        handheldItem(ModItems.PARABELLUM_PICKAXE);
        handheldItem(ModItems.PARABELLUM_AXE);
        handheldItem(ModItems.PARABELLUM_HOE);
        handheldItem(ModItems.INFERNIUM_SWORD);
        handheldItem(ModItems.INFERNIUM_SHOVEL);
        handheldItem(ModItems.INFERNIUM_PICKAXE);
        handheldItem(ModItems.INFERNIUM_AXE);
        handheldItem(ModItems.INFERNIUM_HOE);

        simpleItem(ModItems.BLOOD_RUBY_HELMET);
        simpleItem(ModItems.BLOOD_RUBY_CHESTPLATE);
        simpleItem(ModItems.BLOOD_RUBY_LEGGINGS);
        simpleItem(ModItems.BLOOD_RUBY_BOOTS);
        simpleItem(ModItems.PARABELLUM_HELMET);
        simpleItem(ModItems.PARABELLUM_CHESTPLATE);
        simpleItem(ModItems.PARABELLUM_LEGGINGS);
        simpleItem(ModItems.PARABELLUM_BOOTS);
        simpleItem(ModItems.INFERNIUM_HELMET);
        simpleItem(ModItems.INFERNIUM_CHESTPLATE);
        simpleItem(ModItems.INFERNIUM_LEGGINGS);
        simpleItem(ModItems.INFERNIUM_BOOTS);

        simpleItem(ModItems.HEALING_WATER_BUCKET);

        simpleItem(ModItems.CHA_LA_RECORD);
        simpleItem(ModItems.CHOZETSU_DYNAMIC_RECORD);
        simpleItem(ModItems.DRAGON_SOUL_RECORD);
        simpleItem(ModItems.MAKAFUSHIGI_ADVENTURE_RECORD);

        saplingItem(ModBlocks.AJISA_SAPLING);

        simpleItem(ModItems.AJISA_SIGN);
        simpleItem(ModItems.AJISA_HANGING_SIGN);

        withExistingParent(ModItems.SAIBAMEN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(DragonCraft.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DragonCraft.MOD_ID, "block/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = DragonCraft.MOD_ID;

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DragonCraft.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void simpleBlock(RegistryObject<Block> block) {
        this.withExistingParent(DragonCraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DragonCraft.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DragonCraft.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DragonCraft.MOD_ID,"block/" + item.getId().getPath()));
    }
}
