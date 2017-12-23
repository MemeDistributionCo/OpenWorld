package com.openworld.world;

import java.io.Serializable;

/**
 * WorldChunks are chunks of a world. The purpose of this is to avoid sending an entire Worlds worth of data over to the client, and instead only load relevant portions.
 * @author xDest
 *
 */
public class WorldChunk implements Serializable {
	
	//Data...
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6466746195461249650L;

	public WorldChunk() {
		
	}

}
