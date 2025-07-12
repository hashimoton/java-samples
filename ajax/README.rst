***********************
AJAX
***********************

Historical AJAX call and CORS header



==============
Structure
==============

::

  ├── localquiz.jsp -- Call ssame origin data 
  ├── README.rst -- This file
  ├── src
  │   └── local
  │       └── demo
  │           └── AnswerServlet.java -- 
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

  $ cd /path/to/ajax
  $ ls
  localquiz.jsp  README.rst  src  WEB-INF
  $ javac -cp /opt/jetty-distribution-9.4.57.v20241219/lib/servlet-api-3.1.jar -d WEB-INF/classes src/local/demo/AnswerServlet.java
  $


Deploy
-----------------

Confirm the content of web.xml.

::

  $ cat WEB-INF/web.xml
  <web-app>
    <servlet>
      <servlet-name>AnswerServlet</servlet-name>
      <servlet-class>local.demo.AnswerServlet</servlet-class>
    </servlet>
    <servlet-mapping>
      <servlet-name>AnswerServlet</servlet-name>
      <url-pattern>/answer.xml</url-pattern>
    </servlet-mapping>
  </web-app>

Create a symllink to the webapp.

::

  # cd  /opt/jetty-distribution-9.4.57.v20241219/webapps
  # ln -s /path/to/java-samples/ajax .
 

Get data from same origin
---------------------------

With a browser, open a web page.

http://localhost:8080/ajax/localquiz.jsp

Click "See Answer" to display the data retrived from same origin.
 
http://localhost:8080/ajax/answer.xml



.. EOF

