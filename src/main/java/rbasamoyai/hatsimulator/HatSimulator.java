package rbasamoyai.hatsimulator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import rbasamoyai.hatsimulator.foundation.HatSimGroup;
import rbasamoyai.hatsimulator.foundation.HatSimItems;
import rbasamoyai.hatsimulator.foundation.config.HatSimConfig;

@Mod(HatSimulator.MOD_ID)
public class HatSimulator {

	public static final String MOD_ID = "hatsimulator";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final HatSimGroup MOD_GROUP = new HatSimGroup();
	
	public HatSimulator() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		
		HatSimItems.ITEMS.register(modBus);
		
		HatSimConfig.registerConfigs(modLoadingContext);
	}
	
	public static ResourceLocation resource(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
	
	public static String texture(String name) {
		return MOD_ID + ":textures/models/armor/" + name + ".png";
	}
	
}
