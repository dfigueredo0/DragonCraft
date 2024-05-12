package com.elysiumgames.dragoncraft.world.entity;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.entity.animal.Dragon;
import com.elysiumgames.dragoncraft.world.entity.monster.saibamen.Saibamen;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DragonCraft.MOD_ID);

    public static final RegistryObject<EntityType<Saibamen>> SAIBAMEN = ENTITY_TYPES.register("saibamen",
            () -> EntityType.Builder.of(Saibamen::new, MobCategory.MONSTER).sized(0.895f, 0.895f).build("saibamen"));

    public static final RegistryObject<EntityType<Dragon>> DRAGON = ENTITY_TYPES.register("dragon",
            () -> EntityType.Builder.of(Dragon::new, MobCategory.CREATURE).sized(2.5f, 2.5f).build("dragon"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
