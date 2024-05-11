package com.elysiumgames.dragoncraft.client.model;

import com.elysiumgames.dragoncraft.world.entity.monster.saibamen.Saibamen;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;

// TODO: Create the actual model lol
public class SaibamenModel<T extends Saibamen> extends HierarchicalModel<T> {
    private final ModelPart saibamen;

    public SaibamenModel(ModelPart root) {
        this.saibamen = root.getChild("saibamen");
    }

    @Override
    public ModelPart root() {
        return saibamen;
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        super.renderToBuffer(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    @Override
    public void setupAnim(Saibamen pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
    }

    public static LayerDefinition createBodyLayer() {
        return null;
    }
}
