package rbasamoyai.hatsimulator.foundation.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import rbasamoyai.hatsimulator.HatSimulator;

@Mod.EventBusSubscriber(modid = HatSimulator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HatSimulatorDatagen {

	@SubscribeEvent
	public static void onDatagen(GatherDataEvent evt) {
		DataGenerator gen = evt.getGenerator();
		if (evt.includeClient()) {
			gen.addProvider(new HatSimulatorItemModels(gen, evt.getExistingFileHelper()));
		}
	}
	
}
