package com.elysiumgames.dragoncraft.sound;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DragonCraft.MOD_ID);

    public static final RegistryObject<SoundEvent> CHA_LA_HEAD_CHA_LA = registerSoundEvents("cha_la_head_cha_la");
    public static final RegistryObject<SoundEvent> CHOZETSU_DYNAMIC = registerSoundEvents("chozetsu_dynamic");
    public static final RegistryObject<SoundEvent> DRAGON_SOUL = registerSoundEvents("dragon_soul");
    public static final RegistryObject<SoundEvent> MAKAFUSHIGI_ADVENTURE = registerSoundEvents("makafushigi_adventure");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DragonCraft.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
