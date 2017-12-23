package com.openworld.util.net;

import java.io.Serializable;
import java.net.InetAddress;

public abstract class OPacket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4775191781348629850L;
	private final InetAddress packetSender;
	
	public OPacket(InetAddress from) {
		packetSender = from;
	}
	
	public InetAddress getSender() {
		return packetSender;
	}
	
}
