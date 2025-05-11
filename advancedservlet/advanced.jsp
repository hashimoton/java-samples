<%@page contentType="text/html"  import="java.util.Date"
%>
<%
  System.out.println("JSP begin");
%>
<html>
  <h1>Advanced JSP</h1>

  From <%= new Date() %>
<%
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
%>
  To <%= new Date() %>
</html>
<%
  System.out.println("Handler end");
%>
