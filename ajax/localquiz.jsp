<%@page contentType="text/html" %><%
  System.out.println("JSP begin");
%><!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>AJAX Quiz</title>
</head>
<body>
  <h1>AJAX Quiz</h1>
  <div>Q. What is the first letter?</div>
  <button id="see-answer">See Answer</button>
  <div>A. <span id="answer"></span></div>

  <script>
    document.getElementById("see-answer").onclick = function() {
      var xhr = new XMLHttpRequest();
      xhr.open("GET", "./answer.xml", true);
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

