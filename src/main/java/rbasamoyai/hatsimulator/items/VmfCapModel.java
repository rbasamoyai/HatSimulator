package rbasamoyai.hatsimulator.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import rbasamoyai.hatsimulator.foundation.HatModel;
import rbasamoyai.hatsimulator.foundation.config.HatSimConfig;

public class VmfCapModel extends HatModel {

	private final ModelPart tassels;
	private final ModelPart tassels1;
	
	public VmfCapModel(ModelPart root) {
		super(root);
		this.tassels = root.getChild("head").getChild("cap").getChild("tassels");
		this.tassels1 = this.tassels.getChild("tassels1");
	}
	
	public static LayerDefinition vmfCap() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f);
		PartDefinition part = mesh.getRoot();
		PartDefinition head = part.getChild("head");
		PartDefinition cap = head.addOrReplaceChild("cap", CubeListBuilder.create()
				.texOffs(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 2.0F, 8.0F, CubeDeformation.NONE),
				PartPose.ZERO);
		
		cap.addOrReplaceChild("peak", CubeListBuilder.create()
				.texOffs(0, 49).addBox(-5.0F, -0.9375f, -6.0F, 10.0F, 2.0F, 12.0F, new CubeDeformation(0f, 0.1f, 0f)),
				PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		
		PartDefinition tassels = cap.addOrReplaceChild("tassels", CubeListBuilder.create()
				.texOffs(32, 32).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 0.0F, CubeDeformation.NONE),
				PartPose.offset(0.0F, -6.0F, 4.0F));
		
		tassels.addOrReplaceChild("tassels1", CubeListBuilder.create()
				.texOffs(32, 38).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 0.0F, CubeDeformation.NONE),
				PartPose.offset(0.0F, 6.0F, 0.0F));
		
		return LayerDefinition.create(mesh, 64, 64);
	}
	
	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vCons, int light, int overlay, float r, float g, float b, float a) {
		if (HatSimConfig.CLIENT.simulatedArmorPartsEnabled.get()) {
			
		} else {
			float f = this.head.xRot;
			this.tassels.xRot = -Math.min(f, 0);
			float f1 = Mth.cos(f);
			float f2 = 2f / 3f;
			this.tassels1.xRot = f <= 0 ? 0 : f1 >= f2 ? -f : (float) Math.atan((double)(f2 - f1) / Math.sin(f)) - f;
		}
		super.renderToBuffer(stack, vCons, light, overlay, r, g, b, a);
	}
	
}
