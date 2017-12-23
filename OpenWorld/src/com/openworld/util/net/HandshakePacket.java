package com.openworld.util.net;

import java.net.InetAddress;

public class HandshakePacket extends OPacket {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7324625653655039131L;
	private final String msg;

	public HandshakePacket(InetAddress from, String msg) {
		super(from);
		this.msg = msg;
	}
	
	public String getMessage() {
		return this.msg;
	}

}
