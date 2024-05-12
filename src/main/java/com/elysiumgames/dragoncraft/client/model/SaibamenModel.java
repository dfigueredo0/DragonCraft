package com.elysiumgames.dragoncraft.client.model;

import com.elysiumgames.dragoncraft.world.entity.monster.saibamen.Saibamen;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

// TODO: Create the actual model lol
public class SaibamenModel<T extends Saibamen> extends HierarchicalModel<T> {
    private final ModelPart saibamen;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart torso;
    private final ModelPart left_leg;
    private final ModelPart right_ear;
    private final ModelPart left_ear;
    private final ModelPart shoulder_left;
    private final ModelPart left_arm;
    private final ModelPart shoulder_right;
    private final ModelPart right_arm;
    private final ModelPart right_leg;

    public SaibamenModel(ModelPart root) {
        this.saibamen = root.getChild("saibamen");
        this.body = saibamen.getChild("body");
        this.torso = body.getChild("torso");
        this.head = torso.getChild("head");
        this.right_ear = head.getChild("right_ear");
        this.left_ear = head.getChild("left_ear");
        this.shoulder_left = torso.getChild("shoulder_left");
        this.left_arm = shoulder_left.getChild("left_arm");
        this.shoulder_right = torso.getChild("shoulder_right");
        this.right_arm = shoulder_right.getChild("right_arm");
        this.right_leg = body.getChild("right_leg");
        this.left_leg = body.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition saibamen = partdefinition.addOrReplaceChild("saibamen", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition body = saibamen.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-0.5F, -8.0F, 0.5F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -14.0F, -24.5F, 3.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 8.0F, 21.5F));

        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(17, 17).addBox(-3.025F, -31.0F, -1.55F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.025F, 13.0F, -22.45F));

        PartDefinition left_parietal_r1 = head.addOrReplaceChild("left_parietal_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, -3.5F, 0.0F, 7.0F, 4.0F, 4.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(-1.5F, -29.275F, 0.45F, 0.0F, 0.0F, 0.0F));

        PartDefinition right_parietal_r1 = head.addOrReplaceChild("right_parietal_r1", CubeListBuilder.create().texOffs(18, 0).addBox(-2.5F, -2.5F, -3.0F, 7.0F, 4.0F, 4.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(-1.5F, -30.275F, 0.55F, 0.0F, 0.0F, 0.0F));

        PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, -1.25F, -0.925F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.025F))
                .texOffs(0, 2).addBox(0.0F, -0.95F, -0.65F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.075F))
                .texOffs(0, 0).addBox(0.0F, -0.9F, -0.1F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.125F)), PartPose.offset(0.0F, -28.0F, -2.0F));

        PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, -0.9F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.125F))
                .texOffs(2, 0).addBox(0.0F, -0.95F, -0.45F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.075F))
                .texOffs(2, 2).addBox(0.0F, -1.25F, -0.175F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offset(0.0F, -28.0F, 4.0F));

        PartDefinition shoulder_left = torso.addOrReplaceChild("shoulder_left", CubeListBuilder.create().texOffs(21, 33).addBox(-1.0F, -0.475F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.025F)), PartPose.offset(-1.0F, -13.5F, -17.5F));

        PartDefinition left_arm = shoulder_left.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(21, 26).addBox(-2.0F, -24.0F, -8.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.05F))
                .texOffs(9, 26).addBox(-2.0F, -20.15F, -8.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.075F)), PartPose.offset(1.0F, 24.5F, 7.0F));

        PartDefinition shoulder_right = torso.addOrReplaceChild("shoulder_right", CubeListBuilder.create().texOffs(9, 33).addBox(-1.0F, -0.475F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.025F)), PartPose.offset(-1.0F, -13.5F, -25.525F));

        PartDefinition right_arm = shoulder_right.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.05F))
                .texOffs(18, 8).addBox(-1.5F, 0.875F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.075F)), PartPose.offset(0.5F, 3.5F, -0.5F));

        PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(30, 8).addBox(-1.5F, -0.025F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.025F))
                .texOffs(0, 30).addBox(-1.5F, 2.925F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.025F)), PartPose.offset(0.0F, 2.0F, -1.5F));

        PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(32, 14).addBox(-2.0F, -6.025F, -25.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.025F))
                .texOffs(30, 30).addBox(-2.0F, -3.075F, -25.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.025F)), PartPose.offset(0.5F, 8.0F, 25.0F));

        return LayerDefinition.create(meshdefinition, 45, 45);
    }
    @Override
    public void setupAnim(Saibamen pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        super.renderToBuffer(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    @Override
    public ModelPart root() {
        return saibamen;
    }
}
