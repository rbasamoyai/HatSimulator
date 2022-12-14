package rbasamoyai.hatsimulator.foundation.basicgraphics;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class HatModel extends HumanoidModel<LivingEntity> {

	protected final float scale;
	
	public HatModel(ModelPart root, float scale) {
		super(root);
		this.scale = scale;
	}
	
	public HatModel(ModelPart root) {
		this(root, 1.125f);
	}
	
	protected float getScale() { return scale; }
	
	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vCons, int light, int overlay, float r, float g, float b, float a) {
		float scale = this.getScale();
		stack.pushPose();
		if (this.young) stack.translate(0f, -0.1875f, 0f);
		stack.scale(0.0625f, 0.0625f, 0.0625f);
		stack.translate(this.head.x, this.head.y, this.head.z);
		stack.scale(scale, scale, scale);
		stack.translate(-this.head.x, -this.head.y, -this.head.z);
		stack.scale(16, 16, 16f);
		super.renderToBuffer(stack, vCons, light, overlay, r, g, b, a);
		stack.popPose();
	}
	
}
