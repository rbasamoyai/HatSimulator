package rbasamoyai.hatsimulator.foundation;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class SimpleHatModels {

	public static LayerDefinition marineNationaleCap() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f);
		PartDefinition part = mesh.getRoot();
		PartDefinition head = part.getChild("head");
		
		head.addOrReplaceChild("cap", CubeListBuilder.create()
				.texOffs(0, 44).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE)
				.texOffs(0, 32).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 2.0F, 10.0F, CubeDeformation.NONE)
				.texOffs(0, 60).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(0, 1, 0));
		
		return LayerDefinition.create(mesh, 64, 64);
	}
	
}
