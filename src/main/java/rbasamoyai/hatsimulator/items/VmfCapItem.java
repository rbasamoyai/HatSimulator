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
import rbasamoyai.hatsimulator.foundation.HatSimModelLayers;

public class VmfCapItem extends ArmorItem {

	public VmfCapItem(ArmorMaterial armorMaterial, EquipmentSlot slot, Properties properties) {
		super(armorMaterial, slot, properties);
	}
	
	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
				Minecraft mc = Minecraft.getInstance();
				return new VmfCapModel(mc.getEntityModels().bakeLayer(HatSimModelLayers.VMF_CAP));
			}
		});
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return HatSimulator.MOD_ID + ":textures/models/armor/vmf_cap.png";
	}

}
