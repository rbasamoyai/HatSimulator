package rbasamoyai.hatsimulator.foundation;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import rbasamoyai.hatsimulator.HatSimulator;

public class HatSimGroup extends CreativeModeTab {

	public HatSimGroup() {
		super(HatSimulator.MOD_ID);
	}

	@Override public ItemStack makeIcon() { return new ItemStack(HatSimItems.VMF_CAP.get()); }

}
