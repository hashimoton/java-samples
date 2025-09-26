package local.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/multipart")
@MultipartConfig
public class MultipartServlet extends HttpServlet {

  private static final String[] MOVES = { "R", "P", "S" };


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doPost(request, response);
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String serverMove = MOVES[new Random().nextInt(MOVES.length)];

    String userMove = getUserMove(request);

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
      "You: " + moveName(userMove) + "<br>" +
      "Com: " + moveName(serverMove) + "<br>" +
      "<a href=\"./multipart.jsp\">Play again</a>" +
      "</body></html>"
    );
  }


  private String moveName(String move) {
    switch(move) {
      case "R": return "Rock";
      case "P": return "Paper";
      case "S": return "Scissors";
      default: return "Unknown";
    }
  }


  private String getUserMove(HttpServletRequest request) throws IOException, ServletException {                             String move = request.getParameter("move");                                                                             if (move == null) {                                                                                                       Part movePart = request.getPart("move");                                                                                if (movePart != null) {                                                                                                   try (var is = movePart.getInputStream()) {                                                                                move = new String(is.readAllBytes()).trim();                                                                          }                                                                                                                     }                                                                                                                     }                                                                                                                       return move;                                                                                                          }
}

