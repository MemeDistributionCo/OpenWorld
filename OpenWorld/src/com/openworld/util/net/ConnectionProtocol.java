package com.openworld.util.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ConnectionProtocol implements OProtocol {
	
	public Socket enact(Socket s) {
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			int to = s.getSoTimeout();
			s.setSoTimeout(1000);
			Object clientPacket = ois.readObject();
			if(clientPacket.getClass() != HandshakePacket.class) {
				//reject
				System.out.println("Socket " + s + " sent invalid packet. Ending connection.");
				ois.close();
				s.close();
				s = null;
			} else {
				HandshakePacket hp = (HandshakePacket)clientPacket;
				System.out.println("Socket " + s + " sent valid packet. Handshake: " + hp.getMessage());
			}
			s.setSoTimeout(to);
		} catch (IOException e) {
			e.printStackTrace();
			s = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			s = null;
		}
		return s;
	}

}
