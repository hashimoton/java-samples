package local.demo;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class AdvancedHandler implements HttpHandler {
  
  public void handle(HttpExchange t) throws IOException {
    System.out.println("Handler begin");

    String path = t.getRequestURI().getPath();
    System.out.println("path = " + path);

    for (int i = 0; i < 10; i++) {
    System.out.println(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    t.getResponseHeaders().set("Content-Type", "text/html");
    String response = "<html>Advanced</html>\n";
    t.sendResponseHeaders(200, response.length());
    OutputStream os = t.getResponseBody();
    os.write(response.getBytes());
    os.close();
  	System.out.println("Handler end");
  }
  
}

