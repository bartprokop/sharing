package name.prokop.bart.core;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class EntryPoint {

    public static void main(String... args) throws Exception {
        Server server = new Server(8080);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(HelloServlet.class.getName(), "/");

        server.setHandler(handler);
        server.start();
        server.join();
    }

}
