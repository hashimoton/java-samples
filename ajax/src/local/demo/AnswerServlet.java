package local.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet
{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String url = request.getRequestURL()
      + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
    log("doGet for " + url);

    String cors = request.getParameter("cors");
    if ("true".equals(cors)) {
      response.setHeader("Access-Control-Allow-Origin", "http://example.com:8080");
      response.setHeader("Vary", "Origin");
    }

    response.setContentType("application/xml; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<quiz>");
    out.println("  <id>1</id>");
    out.println("  <answer>A</answer>");
    out.println("</quiz>");
  }

}

