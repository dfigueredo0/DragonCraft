package com.elysiumgames.dragoncraft.painting;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANT = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, DragonCraft.MOD_ID);

    //TODO: Allow for any size png
    public static final RegistryObject<PaintingVariant> ARTWORK_93 = PAINTING_VARIANT.register("artwork_93", () -> new PaintingVariant(64, 32));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANT.register(eventBus);
    }
}
