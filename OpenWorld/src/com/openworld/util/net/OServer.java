package com.openworld.util.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

/**
 * O(pen)Server class. Used to host the game.
 * @author xDest
 *
 */
public class OServer {

	
	
	
	private final ServerSocket socket;
	private boolean started,startedOnce,ended;
	private final Stack<Socket> connections;
	private Thread connectionHandlerThread;
	private GameProtocol gameProtocol;
	
	
	/**
	 * Remember to check if port is in use.
	 * @param portNumber
	 * @throws Exception if the port is in use
	 */
	public OServer(int portNumber) throws Exception {
		socket = new ServerSocket(portNumber);
		started = startedOnce = ended = false;
		connections = new Stack<Socket>();
		gameProtocol = new GameProtocol();
	}

	/**
	 * 
	 */
	public void start() {
		if(!startedOnce) {
			startedOnce = started = true;
		} else if (ended) {
			return;
		}
		//Started once, not ended
		Runnable connectionHandler = new Runnable() {
			@Override
			public void run() {
				while(started && !ended) {
					try {
						Socket incoming = socket.accept();
						handleConnection(incoming);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Failed to accept incoming client");
					}
				}
			}
		};
		connectionHandlerThread = new Thread(connectionHandler);
		startedOnce = true;
		started = true;
		connectionHandlerThread.start();
		Stack<Socket> disconnected = new Stack<Socket>();
		while (started && !ended) {
			for(Socket s : connections) {
				if(s.isClosed() || !s.isConnected()) {
					disconnected.push(s);
					continue;
				}
				gameProtocol.enact(s);
			}
			//Might need to do something faster later maybe, for now it's fine
			for(Socket s : disconnected) {
				connections.remove(s);
			}
			disconnected.clear();
		}
	}
	
	public void gracefulEnd() {
		started = false;
		ended = true;
		//Dispose of all connections/etc
		//Make a wrapper to add listeners to all IO streams
		for(Socket s : connections) {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void end() {
		started = false;
		ended = true;
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void handleConnection(Socket incomingConnection) {
		ConnectionProtocol cp = new ConnectionProtocol();
		incomingConnection = cp.enact(incomingConnection);
		if(incomingConnection != null)
			connections.add(incomingConnection);
	}
	
	
}
