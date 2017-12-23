package com.openworld.world.entity;

import java.io.Serializable;

import com.openworld.util.world.Location3D;
import com.openworld.world.World;

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6231111623783004343L;
	private Location3D location;
	private volatile World w;
	
	public Entity(Location3D entityLocation) {
		this.location = entityLocation;
	}
	
	public Location3D getLocation() {
		return this.location;
	}
	
	public World getWorld() {
		return this.w;
	}
	
}
