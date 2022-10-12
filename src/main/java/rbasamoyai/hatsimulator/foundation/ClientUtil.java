package rbasamoyai.hatsimulator.foundation;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;

public class ClientUtil {

	public static boolean closeEnoughForDetail(Entity entity) {
		return Minecraft.getInstance().getEntityRenderDispatcher().distanceToSqr(entity.getX(), entity.getEyeY(), entity.getZ()) < entity.getBbWidth() * entity.getBbHeight() * 16;
	}
	
}
