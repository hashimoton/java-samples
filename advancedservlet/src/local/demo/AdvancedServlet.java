package local.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdvancedServlet extends HttpServlet
{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log("doGet begin");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html");
    out.println("<h1>Advanced Servlet</h1>");

    String path = request.getRequestURI().toString();
    System.out.println("path = " + path);

    String paramDelay = request.getParameter("delay");
    System.out.println("delay = " + paramDelay);
    int delay = Integer.parseInt(paramDelay);

    for (int i = 0; i < delay; i++) {
    System.out.println(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    out.println("</html>");

    log("doGet end");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log("doPost begin");
    response.setStatus(HttpServletResponse.SC_CREATED);
    response.setContentType("application/json");
    response.getWriter().write("{\"message\": \"Created\"}");
    log("doPost end");
  }
}

