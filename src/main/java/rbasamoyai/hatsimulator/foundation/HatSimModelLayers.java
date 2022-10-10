package rbasamoyai.hatsimulator.foundation;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import rbasamoyai.hatsimulator.HatSimulator;

@Mod.EventBusSubscriber(modid = HatSimulator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HatSimModelLayers {

	public static final ModelLayerLocation VMF_CAP = create("rus_flot_cap");
	
	public static ModelLayerLocation create(String name) {
		return create(name, "main");
	}
	
	public static ModelLayerLocation create(String name, String layer) {
		return new ModelLayerLocation(HatSimulator.resource(name), layer);
	}
	
	@SubscribeEvent
	public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(VMF_CAP, HatSimModels::rusFlotCap);
	}
	
}
