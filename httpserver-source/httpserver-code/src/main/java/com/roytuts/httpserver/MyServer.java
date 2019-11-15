package com.roytuts.httpserver;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import com.roytuts.httpserver.constant.ServerConstant;
import com.roytuts.httpserver.handler.ServerResourceHandler;
import com.sun.net.httpserver.HttpServer;

public class MyServer implements Runnable {

	private static final Logger LOGGER = Logger.getLogger(MyServer.class.getName());

	private static MyServer server;
	private HttpServer httpServer;
	private ExecutorService executor;
	private static String serverHome;
	private static int port;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java -jar <jar name> <server home> <port>");
			System.exit(0);
		}

		serverHome = args[0];
		port = args.length == 1 ? ServerConstant.DEFAULT_PORT : Integer.parseInt(args[1]);

		// port = 8000;
		// serverHome = "C:\\jee_workspace\\httpserver";

		server = new MyServer();

		Thread thread = new Thread(server);
		thread.start();

		Runtime.getRuntime().addShutdownHook(new ShutDown());

		try {
			thread.join();
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		try {
			executor = Executors.newFixedThreadPool(10);

			httpServer = HttpServer.create(new InetSocketAddress(ServerConstant.DEFAULT_HOST, port), 0);
			httpServer.createContext(ServerConstant.FORWARD_SINGLE_SLASH, new ServerResourceHandler(
					serverHome + ServerConstant.FORWARD_SINGLE_SLASH + ServerConstant.WEBAPP_DIR, true, false));
			httpServer.setExecutor(executor);

			LOGGER.info("Starting server...");

			httpServer.start();

			LOGGER.info("Server started => " + ServerConstant.DEFAULT_HOST + ":" + port);

			// Wait here until shutdown is notified
			synchronized (this) {
				try {
					this.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			LOGGER.severe("Error occurred during server starting..." + e);
		}
	}

	static void shutDown() {
		try {
			LOGGER.info("Shutting down server...");
			server.httpServer.stop(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		synchronized (server) {
			server.notifyAll();
		}
	}

}
