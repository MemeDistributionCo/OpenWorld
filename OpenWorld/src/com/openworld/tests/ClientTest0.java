package com.openworld.tests;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.openworld.util.net.OClient;

public class ClientTest0 {

	public static void main(String[] args) {
		try {
			OClient oc = new OClient(5055, InetAddress.getLocalHost(), InetAddress.getByName("127.0.0.1"));
			oc.connect();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
