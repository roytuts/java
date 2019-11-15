package com.roytuts.httpserver;

public class ShutDown extends Thread {

	@Override
	public void run() {
		MyServer.shutDown();
	}
}
