package rbasamoyai.hatsimulator.foundation;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class HatSimModels {

	public static LayerDefinition rusFlotCap() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f);
		PartDefinition part = mesh.getRoot();
		PartDefinition head = part.getChild("head");
		PartDefinition cap = head.addOrReplaceChild("cap", CubeListBuilder.create()
				.texOffs(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE)
				.texOffs(32, 24).addBox(4.0F, 0.0F, -4.0F, 0.0F, 8.0F, 8.0F, CubeDeformation.NONE), PartPose.ZERO);
		cap.addOrReplaceChild("peak", CubeListBuilder.create()
				.texOffs(0, 51).addBox(-6.0F, -2.0F, -5.0F, 12.0F, 3.0F, 10.0F, CubeDeformation.NONE),
				PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		return LayerDefinition.create(mesh, 64, 64);
	}
	
}
