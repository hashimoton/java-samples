<%@ page contentType="text/html; charset=UTF-8" %>
<%!
public static final String START_PAGE = "start.jsp";

private String moveName(String move) {
  switch(move) {
    case "R": return "Rock";
    case "P": return "Paper";
    case "S": return "Scissors";
    default: return "Unknown";
  }
}
%>
<%
String result = null, userMove = null, serverMove = null;
if (session != null) {
    result = (String) session.getAttribute("result");
    userMove = (String) session.getAttribute("userMove");
    serverMove = (String) session.getAttribute("serverMove");
}

if (result == null || userMove == null || serverMove == null) {
    response.sendRedirect(START_PAGE);
    return;
}

session.removeAttribute("result");
session.removeAttribute("userMove");
session.removeAttribute("serverMove");
%>
<html>
<body>
<h1><%= result %></h1>
You: <%= moveName(userMove) %> <br>
Com: <%= moveName(serverMove) %> <br>
<a href="<%= START_PAGE %>">Play again</a>
</body>
</html>
