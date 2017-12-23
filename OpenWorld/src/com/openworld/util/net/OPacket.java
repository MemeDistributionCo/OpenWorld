package com.openworld.util.net;

import java.net.InetAddress;

public abstract class OPacket {

	private final InetAddress packetSender;
	
	public OPacket(InetAddress from) {
		packetSender = from;
	}
	
	public InetAddress getSender() {
		return packetSender;
	}
	
}
