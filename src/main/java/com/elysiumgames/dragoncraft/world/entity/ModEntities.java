package com.elysiumgames.dragoncraft.world.entity;

import com.elysiumgames.dragoncraft.DragonCraft;
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
            () -> EntityType.Builder.of(Saibamen::new, MobCategory.MONSTER).sized(0.75f, 0.75f).build("saibamen"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
