package com.openworld.util.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class OClient {

	private InetAddress self, target;
	private int targetPort;
	private Socket socket;
	
	public OClient(int portNumber, InetAddress self, InetAddress target) {
		this.targetPort = portNumber;
		this.target = target;
		this.self = self;
		socket = null;
	}
	
	public void disconnect() throws NullPointerException,IOException {
		socket.close();
	}
	
	public void connect() throws IOException {
		socket = new Socket(target, targetPort);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(new HandshakePacket(self, "Hit that yeet"));
		oos.close();
		socket.close();
		System.out.println("Closed");
	}
	
}
