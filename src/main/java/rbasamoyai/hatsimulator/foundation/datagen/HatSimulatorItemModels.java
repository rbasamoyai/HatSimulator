package rbasamoyai.hatsimulator.foundation.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import rbasamoyai.hatsimulator.HatSimulator;
import rbasamoyai.hatsimulator.foundation.HatSimItems;

public class HatSimulatorItemModels extends ItemModelProvider {

	public HatSimulatorItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, HatSimulator.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		this.basicItem(HatSimItems.VMF_CAP.get());
		this.basicItem(HatSimItems.MARINE_NATIONALE_CAP.get());
	}

}
