package com.elysiumgames.dragoncraft.compat;

import com.elysiumgames.dragoncraft.DragonCraft;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIDragonCraftPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(DragonCraft.MOD_ID, "jei_plugin");
    }
}
