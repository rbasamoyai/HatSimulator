package rbasamoyai.hatsimulator.foundation;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import rbasamoyai.hatsimulator.HatSimulator;
import rbasamoyai.hatsimulator.items.VmfCapItem;

public class HatSimItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HatSimulator.MOD_ID);
	
	private static <T extends ArmorItem> RegistryObject<T> registerHat(String id, HatFactory<T> factory, ArmorMaterial material, Item.Properties properties) {
		return ITEMS.register(id, () -> factory.create(material, EquipmentSlot.HEAD, properties.tab(HatSimulator.MOD_GROUP)));
	}
	
	private static <T extends ArmorItem> RegistryObject<T> leather(String id, HatFactory<T> factory) {
		return registerHat(id, factory, ArmorMaterials.LEATHER, new Item.Properties());
	}
	
	public static final RegistryObject<VmfCapItem> VMF_CAP = leather("vmf_cap", VmfCapItem::new);
	
	private interface HatFactory<T extends ArmorItem> {
		T create(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties);
	}
	
}
