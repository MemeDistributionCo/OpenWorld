package com.openworld.exception.world;

import com.openworld.world.World;
import com.openworld.world.WorldChunk;

/**
 * This exception is thrown when the chunks do not match the given parent world.
 * @author xDest
 *
 */
public final class WorldChunkMismatchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6864070604072775718L;
	private final World parentWorld;
	private final WorldChunk[] givenChunks,offendingChunks;
	
	/**
	 * This exception is thrown when the chunks do not match the given parent world.
	 * @param parentWorld The world in which the chunks belong
	 * @param worldChunksProvided The chunks provided
	 * @param offendingChunks The chunks which do not belong in the parent world
	 */
	public WorldChunkMismatchException(World parentWorld, WorldChunk[] worldChunksProvided, WorldChunk[] offendingChunks) {
		this.parentWorld = parentWorld;
		this.givenChunks = worldChunksProvided;
		this.offendingChunks = offendingChunks;
	}
	
	public World getParentWorld() {
		return this.parentWorld;
	}
	
	public WorldChunk[] getProvidedChunks() {
		return this.givenChunks;
	}
	
	public WorldChunk[] getOffendingChunks() {
		return this.offendingChunks;
	}
	
}
