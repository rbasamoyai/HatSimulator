package rbasamoyai.hatsimulator.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import rbasamoyai.hatsimulator.foundation.ClientUtil;
import rbasamoyai.hatsimulator.foundation.basicgraphics.HatModel;
import rbasamoyai.hatsimulator.foundation.config.HatSimConfig;

public class MarineNationaleCapModel extends HatModel {

	private final LivingEntity entity;
	private final String capText;
	
	public MarineNationaleCapModel(ModelPart root, LivingEntity entity, String capText) {
		super(root);
		this.entity = entity;
		this.capText = capText;
	}
	
	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer vCons, int light, int overlay, float r, float g, float b, float a) {
		Minecraft mc = Minecraft.getInstance();
		boolean renderDetail = this.entity != null && ClientUtil.closeEnoughForDetail(this.entity);
		stack.pushPose();
		if (this.young) {
			stack.translate(0, 3f / 32f, 0);
		}
		super.renderToBuffer(stack, vCons, light, overlay, r, g, b, a);
		stack.popPose();
		
		if (renderDetail && HatSimConfig.CLIENT.renderTextAtCloseDistances.get()) {
			Font font = mc.font;
			float f = font.width(this.capText) - 1;
			float f1 = Math.max(f / 112f, 1);
			stack.pushPose();
			
			if (this.young) {
				float f2 = 1.5f / 2f;
				stack.scale(f2, f2, f2);
				stack.translate(0, 1, 0);
			}
			
			boolean armorStand = this.entity.getType() == EntityType.ARMOR_STAND;
			if (armorStand) stack.translate(0, 0.0625, 0);
			float f3 = 0.005f / f1;
			
			stack.scale(f3, f3, f3);
			stack.mulPose(Vector3f.ZP.rotation(this.head.zRot));
			stack.mulPose(Vector3f.YP.rotation(this.head.yRot));
			stack.mulPose(Vector3f.XP.rotation(this.head.xRot));
			
			if (armorStand) stack.translate(0, -12, 0);
			
			float f2 = armorStand ? 68 : 81;
			stack.translate(-f / 2, (-this.head.y - f2) * f1, -56.5 * f1);
			font.draw(stack, this.capText, 0, 0, 16177537);
			stack.popPose();
		}
	}
	
}
