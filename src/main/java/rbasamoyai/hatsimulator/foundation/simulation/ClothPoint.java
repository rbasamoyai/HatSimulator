package rbasamoyai.hatsimulator.foundation.simulation;

import net.minecraft.world.phys.Vec3;

public class ClothPoint {

	private Vec3 position;
	private Vec3 prevPosition;
	private final float u;
	private final float v;
	
	public ClothPoint(Vec3 startPos, float u, float v) {
		this.position = startPos;
		this.prevPosition = startPos;
		this.u = u;
		this.v = v;
	}
	
}
