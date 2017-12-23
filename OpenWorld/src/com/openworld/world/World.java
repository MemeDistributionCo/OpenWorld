package com.openworld.world;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class World implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1707420952219048869L;
	private final String worldName;
	private Set<Entity> worldEntities;
	
	public World(String worldName) {
		this.worldName = worldName;
		this.worldEntities = new HashSet<Entity>();
	}
	
	public String getWorldName() {
		return this.worldName;
	}

	
	public Set<Entity> getEntities() {
		return this.worldEntities;
	}
}
