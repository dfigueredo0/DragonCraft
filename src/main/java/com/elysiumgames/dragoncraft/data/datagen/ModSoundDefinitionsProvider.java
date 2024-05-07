package com.elysiumgames.dragoncraft.data.datagen;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.sound.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    protected ModSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, DragonCraft.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {

        add(ModSounds.CHA_LA_HEAD_CHA_LA, definition()
                .subtitle("sounds.dragoncraft.cha_la_record")
                .with(sound(ModSounds.CHA_LA_HEAD_CHA_LA.getId()).stream()));
        add(ModSounds.CHOZETSU_DYNAMIC, definition()
                .subtitle("sounds.dragoncraft.chozetsu_dynamic_record")
                .with(sound(ModSounds.CHOZETSU_DYNAMIC.getId()).stream()));
        add(ModSounds.DRAGON_SOUL, definition()
                .subtitle("sounds.dragoncraft.dragon_soul_record")
                .with(sound(ModSounds.DRAGON_SOUL.getId()).stream()));
        add(ModSounds.MAKAFUSHIGI_ADVENTURE, definition()
                .subtitle("sounds.dragoncraft.makafushigi_adventure_record")
                .with(sound(ModSounds.MAKAFUSHIGI_ADVENTURE.getId()).stream()));
    }
}
