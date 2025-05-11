***********************
Advanced Servelet
***********************

More servlets and JSPs.



==============
Structure
==============

::

├── advanced.jsp -- Advanced JSP sample
├── README.rst
├── simple.jsp -- The simple JSP
├── src
│   └── local
│       └── demo
│           ├── AdvancedServlet.java -- Process query parameter and POST request
│           └── RedirectServlet.java -- Redirect to another page
└── WEB-INF
    └── web.xml -- Deployment configuration file




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

  $ cd /path/to/advancedservlet
  $ ls
  advanced.jsp  README.rst  simple.jsp  src  WEB-INF
  $ javac -cp /opt/jetty-distribution-9.4.57.v20241219/lib/servlet-api-3.1.jar -d WEB-INF/classes src/local/demo/AdvancedServlet.java
  $ javac -cp /opt/jetty-distribution-9.4.57.v20241219/lib/servlet-api-3.1.jar -d WEB-INF/classes src/local/demo/RedirectServlet.java
  $


Deploy
-----------------

Confirm the content of web.xml.

::

  $ cat WEB-INF/web.xml
  <web-app>
    <servlet>
      <servlet-name>SimpleServlet</servlet-name>
      <servlet-class>local.demo.SimpleServlet</servlet-class>
    </servlet>
    <servlet-mapping>
      <servlet-name>SimpleServlet</servlet-name>
      <url-pattern>/simple</url-pattern>
    </servlet-mapping>
    <servlet>
    <servlet-name>RedirectServlet</servlet-name>
      <servlet-class>local.demo.RedirectServlet</servlet-class>
    </servlet>
    <servlet-mapping>
      <servlet-name>RedirectServlet</servlet-name>
      <url-pattern>/redirect</url-pattern>
    </servlet-mapping>
  </web-app>

Copy the files to under Jetty's webapps directory.

::

  # cd  /opt/jetty-distribution-9.4.57.v20241219/webapps
  # mkdir advancedservlet
  # cd advanced
  # cp -pr /path/to/adavancedservlet/*.jsp .
  # cp -pr /path/to/advancedservlet/WEB-INF .
  $ tree
  .
  ├── advanced.jsp
  ├── simple.jsp
  └── WEB-INF
      ├── classes
      │   └── local
      │       └── demo
      │           ├── AdvancedServlet.class
      │           └── RedirectServlet.class
      └── web.xml
  
  4 directories, 5 files
  # touch .
 

Verify the advanced servlet
---------------------------------

GET request with a query parameter
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

From another terminal, access the advanced servlet with curl.

::

  $ curl -v http://localhost:8080/advancedservlet/advanced?delay=3
  *   Trying 127.0.0.1:8080...
  * Connected to localhost (127.0.0.1) port 8080 (#0)
  > GET /advancedservlet/advanced?delay=3 HTTP/1.1
  > Host: localhost:8080
  > User-Agent: curl/7.81.0
  > Accept: */*
  >
  * Mark bundle as not supporting multiuse
  < HTTP/1.1 200 OK
  < Content-Type: text/html;charset=utf-8
  < Content-Length: 40
  < Server: Jetty(9.4.57.v20241219)
  <
  <html
  <h1>Advanced Servlet</h1>
  </html>
  $

POST request resulted status code 201
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

::

  $ curl -v -XPOST http://localhost:8080/advancedservlet/advanced?delay=3
  *   Trying 127.0.0.1:8080...
  * Connected to localhost (127.0.0.1) port 8080 (#0)
  > POST /advancedservlet/advanced?delay=3 HTTP/1.1
  > Host: localhost:8080
  > User-Agent: curl/7.81.0
  > Accept: */*
  >
  * Mark bundle as not supporting multiuse
  < HTTP/1.1 201 Created
  < Content-Type: application/json
  < Content-Length: 22
  < Server: Jetty(9.4.57.v20241219)
  <
  * Connection #0 to host localhost left intact
  {"message": "Created"}$
  $


Verify JSPs
------------------


Simple JSP
~~~~~~~~~~~~~~~~~~~~~

::

  $ curl -v -XPOST http://localhost:8080/advancedservlet/simple.jsp
  *   Trying 127.0.0.1:8080...
  * Connected to localhost (127.0.0.1) port 8080 (#0)
  > POST /advancedservlet/simple.jsp HTTP/1.1
  > Host: localhost:8080
  > User-Agent: curl/7.81.0
  > Accept: */*
  >
  * Mark bundle as not supporting multiuse
  < HTTP/1.1 200 OK
  < Content-Type: text/html;charset=utf-8
  < Set-Cookie: JSESSIONID=node01hd1lvq9duvfv18go6k0m42lke3.node0; Path=/advancedservlet
  < Expires: Thu, 01 Jan 1970 00:00:00 GMT
  < Content-Length: 26
  < Server: Jetty(9.4.57.v20241219)
  <
  <html>
  Simple JSP
  </html>
  * Connection #0 to host localhost left intact
  $


Advanced JSP
~~~~~~~~~~~~~~~~~~~~~

::

  $ curl -v -XPOST http://localhost:8080/advancedservlet/advanced.jsp?delay=3
  *   Trying 127.0.0.1:8080...
  * Connected to localhost (127.0.0.1) port 8080 (#0)
  > POST /advancedservlet/advanced.jsp?delay=3 HTTP/1.1
  > Host: localhost:8080
  > User-Agent: curl/7.81.0
  > Accept: */*
  >
  * Mark bundle as not supporting multiuse
  < HTTP/1.1 200 OK
  < Content-Type: text/html;charset=utf-8
  < Set-Cookie: JSESSIONID=node018j5redysnwdj1rh24y7pam1l34.node0; Path=/advancedservlet
  < Expires: Thu, 01 Jan 1970 00:00:00 GMT
  < Content-Length: 114
  < Server: Jetty(9.4.57.v20241219)
  <
  
  
  <html>
    <h1>Advanced JSP</h1>
  
    From Sun May 10 11:01:17 JST 2025
  
    To Sun May 10 10:11:20 JST 2025
  </html>
  
  * Connection #0 to host localhost left intact
  $


  $

Redirect servlet
------------------


Redirect response
~~~~~~~~~~~~~~~~~~~~~

::

  $ curl -v http://localhost:8080/advancedservlet/redirect
  *   Trying 127.0.0.1:8080...
  * Connected to localhost (127.0.0.1) port 8080 (#0)
  > GET /advancedservlet/redirect HTTP/1.1
  > Host: localhost:8080
  > User-Agent: curl/7.81.0
  > Accept: */*
  >
  * Mark bundle as not supporting multiuse
  < HTTP/1.1 302 Found
  < Location: http://localhost:8080/advancedservlet/simple.jsp
  < Content-Length: 0
  < Server: Jetty(9.4.57.v20241219)
  <
  * Connection #0 to host localhost left intact
  $


Redirect processing at client side
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

::

  $ curl -vL http://localhost:8080/advancedservlet/redirect
  *   Trying 127.0.0.1:8080...
  * Connected to localhost (127.0.0.1) port 8080 (#0)
  > GET /advancedservlet/redirect HTTP/1.1
  > Host: localhost:8080
  > User-Agent: curl/7.81.0
  > Accept: */*
  >
  * Mark bundle as not supporting multiuse
  < HTTP/1.1 302 Found
  < Location: http://localhost:8080/advancedservlet/simple.jsp
  < Content-Length: 0
  < Server: Jetty(9.4.57.v20241219)
  <
  * Connection #0 to host localhost left intact
  * Issue another request to this URL: 'http://localhost:8080/advancedservlet/simple.jsp'
  * Found bundle for host localhost: 0x561c3f99f5a0 [serially]
  * Can not multiplex, even if we wanted to!
  * Re-using existing connection! (#0) with host localhost
  * Connected to localhost (127.0.0.1) port 8080 (#0)
  > GET /advancedservlet/simple.jsp HTTP/1.1
  > Host: localhost:8080
  > User-Agent: curl/7.81.0
  > Accept: */*
  >
  * Mark bundle as not supporting multiuse
  < HTTP/1.1 200 OK
  < Content-Type: text/html;charset=utf-8
  < Set-Cookie: JSESSIONID=node01edmk10wrw0fv12fmpsys3awip5.node0; Path=/advancedservlet
  < Expires: Thu, 01 Jan 1970 00:00:00 GMT
  < Content-Length: 26
  < Server: Jetty(9.4.57.v20241219)
  <
  <html>
  Simple JSP
  </html>
  * Connection #0 to host localhost left intact
  $


.. EOF

