package com.elysiumgames.dragoncraft.world.level.block.entity;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DragonCraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<DragonBallBlockEntity>> DRAGON_BALL_BE = BLOCK_ENTITIES.register("dragon_ball",
            () -> BlockEntityType.Builder.of(DragonBallBlockEntity::new, ModBlocks.DRAGON_BALL.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITIES.register("mod_sign",
            () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
                    ModBlocks.AJISA_SIGN.get(), ModBlocks.AJISA_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITIES.register("mod_hanging_sign",
            () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
                    ModBlocks.AJISA_HANGING_SIGN.get(), ModBlocks.AJISA_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
