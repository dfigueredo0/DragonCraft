package com.elysiumgames.dragoncraft.client.renderer.entity;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.client.model.SaibamenModel;
import com.elysiumgames.dragoncraft.client.model.geom.ModModelLayers;
import com.elysiumgames.dragoncraft.world.entity.monster.saibamen.Saibamen;
import com.elysiumgames.dragoncraft.world.entity.monster.saibamen.Variant;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class SaibamenRenderer extends MobRenderer<Saibamen, SaibamenModel<Saibamen>> {
    private static final Map<Variant, ResourceLocation> LOCATION_BY_VARIANT = Util.make(Maps.newEnumMap(Variant.class), map -> {
       map.put(Variant.DEFAULT, new ResourceLocation(DragonCraft.MOD_ID, "textures/entity/saibamen.png"));
       map.put(Variant.KYUKONMAN, new ResourceLocation(DragonCraft.MOD_ID, "textures/entity/kyukonman.png"));
       map.put(Variant.TENNENMAN, new ResourceLocation(DragonCraft.MOD_ID, "textures/entity/tennenman.png"));
       map.put(Variant.JINKOUMAN, new ResourceLocation(DragonCraft.MOD_ID, "textures/entity/jinkouman.png"));
       map.put(Variant.KAIWAREMAN, new ResourceLocation(DragonCraft.MOD_ID, "textures/entity/kaiwareman.png"));
       map.put(Variant.COPYMAN, new ResourceLocation(DragonCraft.MOD_ID, "textures/entity/copyman.png"));
    });

    public SaibamenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SaibamenModel<>(pContext.bakeLayer(ModModelLayers.SAIBAMEN_LAYER)), 0.95F);
    }

    @Override
    public ResourceLocation getTextureLocation(Saibamen pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }
}
