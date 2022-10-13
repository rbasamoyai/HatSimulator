package rbasamoyai.hatsimulator.items;

import java.util.function.Consumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import rbasamoyai.hatsimulator.HatSimulator;
import rbasamoyai.hatsimulator.foundation.ClientUtil;
import rbasamoyai.hatsimulator.foundation.basicgraphics.HatSimModelLayers;
import rbasamoyai.hatsimulator.foundation.config.HatSimConfig;

public class MarineNationaleCapItem extends ArmorItem {
	
	public MarineNationaleCapItem(ArmorMaterial material, Properties properties) {
		super(material, EquipmentSlot.HEAD, properties);
	}
	
	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
				Minecraft mc = Minecraft.getInstance();
				String capText = itemStack.hasCustomHoverName() ? itemStack.getHoverName().getString() : "MARINE NATIONALE";
				return new MarineNationaleCapModel(mc.getEntityModels().bakeLayer(HatSimModelLayers.MARINE_NATIONALE_CAP), entityLiving, capText);
			}
		});
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return HatSimulator.texture("marine_nationale_cap" + (HatSimConfig.CLIENT.renderTextAtCloseDistances.get() && ClientUtil.closeEnoughForDetail(entity) ? "_text" : ""));
	}
	
}
