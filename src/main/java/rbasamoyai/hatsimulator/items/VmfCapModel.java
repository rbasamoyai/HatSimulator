package rbasamoyai.hatsimulator.items;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import rbasamoyai.hatsimulator.foundation.ClientUtil;
import rbasamoyai.hatsimulator.foundation.basicgraphics.HatModel;
import rbasamoyai.hatsimulator.foundation.config.HatSimConfig;

public class VmfCapModel extends HatModel {

	private final ModelPart tassels;
	private final ModelPart tassels1;
	private final String capText;
	@Nullable private LivingEntity entity;
	
	public VmfCapModel(ModelPart root, LivingEntity entity, String capText) {
		super(root);
		this.tassels = root.getChild("head").getChild("cap").getChild("tassels");
		this.tassels1 = this.tassels.getChild("tassels1");
		this.capText = capText;
		this.entity = entity;
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
		Minecraft mc = Minecraft.getInstance();
		boolean renderDetail = this.entity != null && ClientUtil.closeEnoughForDetail(this.entity);
		if (renderDetail && HatSimConfig.CLIENT.simulatedArmorPartsEnabled.get()) {
			this.tassels.visible = false;
			
			
		} else {
			float f = this.head.xRot;
			this.tassels.xRot = -Math.min(f, 0);
			float f1 = Mth.cos(f);
			float f2 = 2f / 3f;
			this.tassels1.xRot = f <= 0 ? 0 : f1 >= f2 ? -f : (float) Math.atan((double)(f2 - f1) / Math.sin(f)) - f;
		}
		super.renderToBuffer(stack, vCons, light, overlay, r, g, b, a);
		this.tassels.visible = true;
		
		if (renderDetail && HatSimConfig.CLIENT.renderTextAtCloseDistances.get()) {
			//this.head.render(stack, vCons, light, overlay);
			Font font = mc.font;
			float f = font.width(this.capText) - 1;
			float f1 = f / 112f;
			stack.pushPose();
			
			stack.scale(0.005f / f1, 0.005f / f1, 0.005f / f1);
			stack.mulPose(Vector3f.ZP.rotation(this.head.zRot));
			stack.mulPose(Vector3f.YP.rotation(this.head.yRot));
			stack.mulPose(Vector3f.XP.rotation(this.head.xRot));
			float f2 = entity.getType() == EntityType.ARMOR_STAND ? 93 : 106;
			if (this.entity.getType() == EntityType.ARMOR_STAND) {
				
			} else {
				stack.translate(-f / 2, (-this.head.y - f2) * f1, -57 * f1);
			}
			font.draw(stack, this.capText, 0, 0, 16570144);
			stack.popPose();
		}
	}
	
}
