package info.hyperreal.acid.stats;

import com.google.inject.servlet.GuiceFilter;
import info.hyperreal.acid.stats.servlet.AcidStatsServletConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting server on port 8080 suczko");
        Server server = new Server(8080);
        ServletContextHandler sch = new ServletContextHandler(server, "/");
        sch.addEventListener(new AcidStatsServletConfig());
        sch.addFilter(GuiceFilter.class, "/*", null);
        sch.addServlet(DefaultServlet.class, "/");
        server.start();
        server.join();
    }

}
