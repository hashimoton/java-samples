***********************
Simple Servelet
***********************

Run a simple servlet on servlet containers.



==============
Structure
==============

::

  ├── README.rst -- This file
  ├── src
  │   └── local
  │       └── demo
  │           └── SimpleServlet.java -- The simple servlet code
  └── WEB-INF
      └── web.xml -- Deployment configuration file



====================
Exercise with Jetty
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

Test run Jetty
~~~~~~~~~~~~~~~~

::

  # java -jar start.jar  

Access http://localhost:8080/ with a browser.
Once you see the Jetty's page, press Ctrl+C to stop Jetty.


Compile with Jetty
--------------------

Back to your directory of this repository.

::

  $ cd /path/to/simpleservlet
  $ ls
  src  WEB-INF
  $ javac -cp /opt/jetty-distribution-9.4.57.v20241219/lib/servlet-api-3.1.jar -d WEB-INF/classes src/local/demo/SimpleServlet.java
  $
  $ ls WEB-INF/classes/local/demo/SimpleServlet.class
  WEB-INF/classes/local/demo/SimpleServlet.class


Deploy to Jetty
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
  </web-app>

Copy the files to under Jetty's webapps directory.

::

  # cd  /opt/jetty-distribution-9.4.57.v20241219/webapps
  # mkdir simpleservlet
  # cd simpleservlet
  # cp -pr /path/to/simpleservlet/WEB-INF .
  $ tree
  └── WEB-INF
      ├── classes
      │   └── local
      │       └── demo
      │           └── SimpleServlet.class
      └── web.xml
  
 4 directories, 2 files
 

Verify on Jetty
-----------------

From another terminal, access http://localhost:8000 with curl.

::

  $ curl http://localhost:8080/simpleservlet/simple
  Simple
  $


=====================
Exersize with Tomcat
=====================


Setup Tomcat
-----------------

Download and install
~~~~~~~~~~~~~~~~~~~~~~~

https://tomcat.apache.org/download-90.cgi

::

  # cd /opt
  # wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.104/bin/apache-tomcat-9.0.104.tar.gz
  # tar zxf apache-tomcat-9.0.104.tar.gz
  # cd apache-tomcat-9.0.104
  # ls
  bin           conf             lib      logs    README.md      RUNNING.txt  webapps
  BUILDING.txt  CONTRIBUTING.md  LICENSE  NOTICE  RELEASE-NOTES  temp         work
  #

Test run Tomcat
~~~~~~~~~~~~~~~~

::

  # bin/startup.sh

Access http://localhost:8080/ with a browser.
Once you see the Tomcat's page, stop Tomcat.

::

  # bin/shutdown.sh
 

Deploy to Tomcat
-------------------


Restart Tomcat.

::

  # bin/startup.sh

Copy the files from Jetty's webapps directory to under Tomcat's webapps directory.

::

  ## cd /opt/apache-tomcat-9.0.104/webapps
  ## cp -r /us/opt/jetty-distribution-9.4.57.v20241219/webapps/simpleservlet .

Verify on Tomcat
-----------------

From another terminal, access http://localhost:8000 with curl.

::

  $ curl http://localhost:8080/simpleservlet/simple
  Simple
  $


.. EOF

