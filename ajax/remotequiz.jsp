<%@page contentType="text/html" %><%
  System.out.println("JSP begin");
%><!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Remote AJAX Quiz</title>
</head>
<body>
  <h1>RemoteAJAX Quiz</h1>
  <div>Q. What is the first letter?</div>
  <input type="text" id="answer-url" value="http://localhost:8080/ajax/answer.xml" size="50">
  <button id="see-answer">See Answer</button>
  <div>A. <span id="answer"></span></div>

  <script>
    var url = document.getElementById("answer-url").value.trim();
    if (url)
    document.getElementById("see-answer").onclick = function() {
      var url = document.getElementById("answer-url").value.trim();
      var xhr = new XMLHttpRequest();
      xhr.open("GET", url, true);
      xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
          if (xhr.status === 200 && xhr.responseXML) {
            var quizElem = xhr.responseXML.getElementsByTagName('quiz')[0];
            var answer = quizElem.getElementsByTagName('answer')[0].textContent;
            document.getElementById("answer").textContent =answer;
          } else {
            document.getElementById("answer").textContent = "Failed to get data: " + xhr.status + " " + xhr.statusText;
          }
        }
      };
      xhr.send();
    };
  </script>
</body>
</html>

