package rbasamoyai.hatsimulator.foundation;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class HatSimGroup extends CreativeModeTab {

	public HatSimGroup() {
		super("base");
	}

	@Override public ItemStack makeIcon() { return new ItemStack(HatSimItems.VMF_CAP.get()); }

}
