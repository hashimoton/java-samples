package local.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;

public class SimpleServer {
  
  public static void main(String args[]) {
    try {
      HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
      server.createContext("/", new SimpleHandler());
      server.setExecutor(null);
      server.start();
      System.out.println("Started");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
