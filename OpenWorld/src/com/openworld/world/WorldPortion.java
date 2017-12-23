package com.openworld.world;

import java.util.ArrayList;
import java.util.List;

import com.openworld.exception.world.WorldChunkMismatchException;

/**
 * WorldPortion is what is sent to the client to give them information about the surrounding world, rather than the entire world.
 * @author xDest
 *
 */
public class WorldPortion {

	private WorldChunk[] worldChunks;
	private volatile World worldOwner;
	
	public WorldPortion(WorldChunk[] chunks, World parentWorld) throws WorldChunkMismatchException,NullPointerException {
		if(chunks == null || parentWorld == null) {
			throw new NullPointerException("Do not provide null parameters");
		}
		this.worldChunks = chunks;
		this.worldOwner = parentWorld;
		List<WorldChunk> offendingChunks = new ArrayList<WorldChunk>();
		for(WorldChunk c : worldChunks) {
			if(!worldOwner.containsChunk(c)) {
				offendingChunks.add(c);
			}
		}
		if(!offendingChunks.isEmpty()) {
			WorldChunk[] arr = new WorldChunk[offendingChunks.size()];
			for (int i = 0; i < offendingChunks.size(); i++) {
				arr[i] = offendingChunks.get(i);
			}
			throw new WorldChunkMismatchException(parentWorld, chunks, arr);
		}
	}
	
}
