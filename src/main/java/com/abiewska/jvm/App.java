package com.abiewska.jvm;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {
	public static void main(String[] args) throws Exception {

		ResourceConfig config = new ResourceConfig().packages("com.abiewska.jvm");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(5555);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.destroy();
		}

	}
}
