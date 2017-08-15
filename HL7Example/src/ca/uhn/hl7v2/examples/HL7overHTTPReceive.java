package ca.uhn.hl7v2.examples;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import ca.uhn.hl7v2.hoh.hapi.server.HohServlet;

public class HL7overHTTPReceive {
	public static void main(String[] args) {
		// The port to listen on
		int port = 5105;

		// Create a Jetty server instance
		Server server = new Server(port);
		ServletContextHandler context = new ServletContextHandler(server, "/Hl7Listener", ServletContextHandler.SESSIONS);
		HohServlet servlet = new HL7overHTTPReceiveServlet();

		/* 
		 * Adds the servlet to listen at 
		 * http://localhost:5105/Hl7Listener/Incoming
		 */
		context.addServlet(new ServletHolder(servlet), "/Incoming");

		// Start the server
		try {
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// .. let the application run ..

		/*
		 * Later it will probably be appropriate to shut the server
		 * down.
		 */
//		try {
//			server.stop();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
