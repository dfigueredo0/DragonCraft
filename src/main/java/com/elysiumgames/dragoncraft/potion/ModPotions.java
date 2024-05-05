package com.elysiumgames.dragoncraft.potion;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, DragonCraft.MOD_ID);

    public static final RegistryObject<Potion> DIVINE_WATER = POTIONS.register("dragoncraft_divine_water",
            Potion::new);
    public static final RegistryObject<Potion> ULTRA_DIVINE_WATER = POTIONS.register("dragoncraft_ultra_divine_water",
            Potion::new);

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
