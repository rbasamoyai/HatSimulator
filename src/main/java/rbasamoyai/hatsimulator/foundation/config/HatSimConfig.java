package rbasamoyai.hatsimulator.foundation.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import rbasamoyai.hatsimulator.HatSimulator;

@Mod.EventBusSubscriber(modid = HatSimulator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HatSimConfig {
	
	public static class CClient {
		public final BooleanValue simulatedArmorPartsEnabled;
		
		public final BooleanValue renderTextAtCloseDistances;
		
		CClient(ForgeConfigSpec.Builder builder) {
			builder
			.comment("Client-side config for Hat Simulator.")
			.push("client");
			
			simulatedArmorPartsEnabled = builder
				.comment("If certain features of hats (e.g. ribbons) should use cloth simulation.")
				.translation(HatSimulator.MOD_ID + ".configgui.simulatedArmorPartsEnabled")
				.define("simulatedArmorPartsEnabled", true);
			
			renderTextAtCloseDistances = builder
				.comment("If certain hats should render text. Text will only be seen at close distances.")
				.translation(HatSimulator.MOD_ID + ".configgui.renderTextAtCloseDistances")
				.define("renderTextAtCloseDistances", true);
			
			builder.pop();
		}
	}
	
	private static final ForgeConfigSpec CLIENT_SPEC;
	public static final CClient CLIENT;
	static {
		final Pair<CClient, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CClient::new);
		CLIENT = specPair.getLeft();
		CLIENT_SPEC = specPair.getRight();
	}
	
	public static void registerConfigs(ModLoadingContext ctx) {
		ctx.registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC);
	}
	
}
