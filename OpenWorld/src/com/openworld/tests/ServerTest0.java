package com.openworld.tests;

import com.openworld.util.net.OServer;

public class ServerTest0 {
	
	public static void main(String[] args) {
		try {
			OServer os = new OServer(5055);
			os.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
