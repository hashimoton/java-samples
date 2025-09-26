package local.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

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

    response.setStatus(HttpServletResponse.SC_OK);
    response.setContentType("text/html; charset=UTF-8");
    response.getWriter().write(
      "<html><body>" +
      "<h1>" + result + "</h1>" +
      "You: " + handName(userMove) + "<br>" +
      "Com: " + handName(serverMove) + "<br>" +
      "<a href=\"./choose.jsp\">Play again</a>" +
      "</body></html>"
    );
  }


  private String handName(String move) {
    switch(move) {
      case "R": return "Rock";
      case "P": return "Paper";
      case "S": return "Scissors";
      default: return "Unknown";
    }
  }
}

