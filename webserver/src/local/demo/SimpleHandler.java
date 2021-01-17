package local.demo;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class SimpleHandler implements HttpHandler {
  
  public void handle(HttpExchange t) throws IOException {
    System.out.println("Requested");
    String response = "Simple Web Server\n";
    t.sendResponseHeaders(200, response.length());
    OutputStream os = t.getResponseBody();
    os.write(response.getBytes());
    os.close();
  	System.out.println("Responded");
  }
  
}

