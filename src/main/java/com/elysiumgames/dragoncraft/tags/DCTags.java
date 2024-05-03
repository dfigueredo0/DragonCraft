package com.elysiumgames.dragoncraft.tags;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DCTags {
    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DragonCraft.MOD_ID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> VALUABLES = tag("valuables");
        public static final TagKey<Block> NEEDS_INFERNIUM_TOOL = tag("needs_infernium_tools");
        public static final TagKey<Block> NEEDS_PARABELLUM_TOOLS = tag("needs_parabellum_tools");
        public static final TagKey<Block> NEEDS_BLOOD_RUBY_TOOLS = tag("needs_blood_ruby_tools");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DragonCraft.MOD_ID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
