***********************
RPS Form
***********************

Rock-Paper-Scissors game for form requests.



==============
Structure
==============

::

  ├── choose.jsp -- Move choise form (application/x-www-form-urlencoded)
  ├── multipart.jsp -- Move choise form (multipart/form-data)
  ├── README.rst -- This file
  ├── src
  │   └── local
  │       └── demo
  │           ├── MultipartServlet.java -- Show result (multipart/form-data)
  │           └── ResultServlet.java  -- Show result (application/x-www-form-urlencoded)
  └── WEB-INF


====================
Exercise
====================


Setup Jetty
---------------

Download and install
~~~~~~~~~~~~~~~~~~~~~~~~~

https://jetty.org/download.html

::

  # cd /opt
  # wget https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.57.v20241219/jetty-distribution-9.4.57.v20241219.tar.gz
  # tar zxf jetty-distribution-9.4.57.v20241219.tar.gz
  # cd jetty-distribution-9.4.57.v20241219/
  # ls
  bin        etc  license-eplv10-aslv20.html  modules      README.TXT  start.ini  VERSION.txt
  demo-base  lib  logs                        notice.html  resources   start.jar  webapps
  #

Run Jetty
~~~~~~~~~~~~~~~~

::

  # java -jar start.jar  

Access http://localhost:8080/ with a browser.


Compile
--------------------

Back to your directory of this repository.

::

  $ cd /path/to/rpsform
  $ ls
  choose.jsp  multipart.jsp  README.rst  src  WEB-INF
  $ javac -cp /opt/jetty-distribution-9.4.57.v20241219/lib/servlet-api-3.1.jar -d WEB-INF/classes src/local/demo/ResultServlet.java
  $ javac -cp /opt/jetty-distribution-9.4.57.v20241219/lib/servlet-api-3.1.jar -d WEB-INF/classes src/local/demo/MultipartServlet.java
  $


Deploy
-----------------

Create a symlink under Jetty's webapps directory.

::

  # cd  /opt/jetty-distribution-9.4.57.v20241219/webapps
  # ln -s /path/to/rpsform .
 

POST request as application/x-www-form-urlencoded
----------------------------------------------------

Play the game
~~~~~~~~~~~~~~~~

With Browser's DevTools, open Network tab.

Go to the game form at the following URL.

http://localhost:8080/rpsform/choose.jsp

Choose "Rock" then click "Shoot!".

You see either of "WIN!", "LOSE!", or "TIE!" in the result page.

Select the following request. Payload > View Source should be "move=R".

POST http://localhost:8080/rpsform/result


Effect of reloading
~~~~~~~~~~~~~~~~~~~~

Rload the result page several times. The result should change.

The same request with the payload is sent on each reloading.


See the HTTP communication with curl
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

curl -d sends the form parameters as "application/x-www-form-urlencoded".
Note Content-Type header and the following lines for the payload.

::

  $ curl --trace-ascii - -d 'move=R' http://localhost:8080/rpsform/result
  == Info:   Trying 127.0.0.1:8080...
  == Info: Connected to localhost (127.0.0.1) port 8080 (#0)
  => Send header, 161 bytes (0xa1)
  0000: POST /rpsform/result HTTP/1.1
  001f: Host: localhost:8080
  0035: User-Agent: curl/7.81.0
  004e: Accept: */*
  005b: Content-Length: 6
  006e: Content-Type: application/x-www-form-urlencoded
  009f:
  => Send data, 6 bytes (0x6)
  0000: move=R
  == Info: Mark bundle as not supporting multiuse
  <= Recv header, 17 bytes (0x11)
  0000: HTTP/1.1 200 OK
  <= Recv header, 39 bytes (0x27)
  0000: Content-Type: text/html;charset=utf-8
  <= Recv header, 21 bytes (0x15)
  0000: Content-Length: 106
  <= Recv header, 33 bytes (0x21)
  0000: Server: Jetty(9.4.57.v20241219)
  <= Recv header, 2 bytes (0x2)
  0000:
  <= Recv data, 106 bytes (0x6a)
  0000: <html><body><h1>WIN!</h1>You: Rock<br>Com: Scissors<br><a href="
  0040: ./choose.jsp">Play again</a></body></html>
  <html><body><h1>WIN!</h1>You: Rock<br>Com: Scissors<br><a href="./choose.jsp">Play again</a></body></html>== Info: Connection #0 to host localhost left intact
  $


POST request as multipart/form-data
----------------------------------------

Play the game
~~~~~~~~~~~~~~~~

Go to the game form at the following URL.

http://localhost:8080/rpsform/multipart.jsp

Choose "Rock" then click "Shoot!".

You see either of WIN!, LOSE!, or TIE!.

Select the following request. Payload > View Source should be "move=R".
Also note that Content-Type request header looks like "multipart/form-data; boundary=----WebKitFormBoundarykEjYByaVBXAtVdxB".

http://localhost:8080/rpsform/multipart

Rload the page several times. The result should change despite that the request is same.

See the HTTP communication with curl
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

curl -F sends the form parameters as "multipart/formdata".
Note Content-Type header and the following lines for the payload which is sent a different way with "-d".

::

  $ curl --trace-ascii - -F 'move=R' http://localhost:8080/rpsform/multipart
  == Info:   Trying 127.0.0.1:8080...
  == Info: Connected to localhost (127.0.0.1) port 8080 (#0)
  => Send header, 203 bytes (0xcb)
  0000: POST /rpsform/multipart HTTP/1.1
  0022: Host: localhost:8080
  0038: User-Agent: curl/7.81.0
  0051: Accept: */*
  005e: Content-Length: 140
  0073: Content-Type: multipart/form-data; boundary=--------------------
  00b3: ----a048c7ba5135a3b7
  00c9:
  => Send data, 140 bytes (0x8c)
  0000: --------------------------a048c7ba5135a3b7
  002c: Content-Disposition: form-data; name="move"
  0059:
  005b: R
  005e: --------------------------a048c7ba5135a3b7--
  == Info: We are completely uploaded and fine
  == Info: Mark bundle as not supporting multiuse
  <= Recv header, 17 bytes (0x11)
  0000: HTTP/1.1 200 OK
  <= Recv header, 39 bytes (0x27)
  0000: Content-Type: text/html;charset=utf-8
  <= Recv header, 21 bytes (0x15)
  0000: Content-Length: 105
  <= Recv header, 33 bytes (0x21)
  0000: Server: Jetty(9.4.57.v20241219)
  <= Recv header, 2 bytes (0x2)
  0000:
  <= Recv data, 105 bytes (0x69)
  0000: <html><body><h1>TIE!</h1>You: Rock<br>Com: Rock<br><a href="./mu
  0040: ltipart.jsp">Play again</a></body></html>
  <html><body><h1>TIE!</h1>You: Rock<br>Com: Rock<br><a href="./multipart.jsp">Play again</a></body></html>== Info: Connection #0 to host localhost left intact
  $


.. EOF

