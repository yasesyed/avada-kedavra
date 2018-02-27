package java.java.app.networking;

public class SingleThreadedClient {

    public static void startServer(Integer port) {
        SingleThreadedServer server = new SingleThreadedServer(port);
        new Thread(server).start();

        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();

    }

    public static void main(String[] args) {
        startServer(9000);
    }


}

