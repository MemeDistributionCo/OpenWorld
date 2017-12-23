package com.openworld.util.net;

import java.net.Socket;

/**
 * Will do more with this later
 * @author xDest
 *
 */
public interface OProtocol {
	
	/**
	 * Enact upon the provided socket.
	 * @param s The socket
	 * @return The socket, or null
	 */
	Socket enact(Socket s);
	
}
