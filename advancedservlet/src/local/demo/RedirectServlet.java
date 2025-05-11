package local.demo;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet
{

  String redirectTo = "simple.jsp";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    response.sendRedirect(redirectTo);
  }
}

