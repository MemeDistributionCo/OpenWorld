package com.openworld.util.net;

import java.net.InetAddress;

public class HandshakePacket extends OPacket {
	
	private final String msg;

	public HandshakePacket(InetAddress from, String msg) {
		super(from);
		this.msg = msg;
	}
	
	public String getMessage() {
		return this.msg;
	}

}
