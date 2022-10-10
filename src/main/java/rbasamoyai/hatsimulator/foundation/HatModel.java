package rbasamoyai.hatsimulator.foundation;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class HatModel extends HumanoidModel<LivingEntity> {

	public HatModel(ModelPart root) { super(root); }
	
	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vCons, int light, int overlay, float r, float g, float b, float a) {
		stack.pushPose();
		if (this.young) stack.translate(0f, -0.1875f, 0f);
		stack.translate(this.head.x / 16f, this.head.y / 16f, this.head.z / 16f);
		stack.scale(1.25f, 1.25f, 1.25f);
		stack.translate(-this.head.x / 16f, -this.head.y / 16f, -this.head.z / 16f);
		super.renderToBuffer(stack, vCons, light, overlay, r, g, b, a);
		stack.popPose();
	}
	
}
