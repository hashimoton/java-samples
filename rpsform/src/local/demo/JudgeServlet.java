package local.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/judge")
public class JudgeServlet extends HttpServlet {

  private static final String[] MOVES = { "R", "P", "S" };


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doPost(request, response);
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String serverMove = MOVES[new Random().nextInt(MOVES.length)];

    String userMove = request.getParameter("move");

    String result = "LOSE!";
    if(userMove.equals(serverMove)) {
      result = "TIE!";
    } else if (
        (userMove.equals("R") && serverMove.equals("S")) ||
        (userMove.equals("P") && serverMove.equals("R")) ||
        (userMove.equals("S") && serverMove.equals("P"))
    ) {
      result = "WIN!";
    }

    HttpSession session = request.getSession();
    session.setAttribute("result", result);
    session.setAttribute("userMove", userMove);
    session.setAttribute("serverMove", serverMove);

    response.sendRedirect("result.jsp");
  }
}

