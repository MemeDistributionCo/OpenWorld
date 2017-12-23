package com.openworld.util.world;

import java.io.Serializable;

/**
 * Immutable Location class representing a location in a 3D space
 * @author xDest
 *
 */
public final class Location3D implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7803396217393426548L;
	private final double x,y,z;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Location3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString() {
		return "Location3D: " + this.x + ", " + this.y + ", " + this.z;
	}
	
	public final double getX() {
		return this.x;
	}
	
	public final double getY() {
		return this.y;
	}
	
	public final double getZ() {
		return this.z;
	}
	
	public final Location3D addX(double addX) {
		return new Location3D(x + addX, y,z);
	}
	
	public final Location3D addY(double addY) {
		return new Location3D(x, y + addY, z);
	}
	
	public final Location3D addZ(double addZ) {
		return new Location3D(x,y,z+addZ);
	}
	

}
