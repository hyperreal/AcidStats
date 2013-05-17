package info.hyperreal.acid.stats;

import org.eclipse.jetty.server.Server;

public class Main {

    public static void main(String[] args) throws Exception {
        printWelcome();
        Server server = new Server(8080);
        server.start();
        server.join();
    }

    private static void printWelcome() {
        System.out.println("------------------------------------------------------------");
        System.out.println("                 Welcome to AcidStats!");
        System.out.println("------------------------------------------------------------");
    }

}
