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
---------------------------------

With Browser's DevTools, open Network tab.

Go to the game form at the following URL.

http://localhost:8080/rpsform/choose.jsp

Choose "Rock" then click "Shoot!".

You see either of WIN!, LOSE!, or TIE!.

Select the following request. Payload > View Source should be "move=R".

http://localhost:8080/rpsform/result

Rload the page several times. The result should change.

TBD: Simulate the browser access with curl.


POST request as multipart/form-data
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Go to the game form at the following URL.

http://localhost:8080/rpsform/multipart.jsp

Choose "Rock" then click "Shoot!".

You see either of WIN!, LOSE!, or TIE!.

Select the following request. Payload > View Source should be "move=R".

http://localhost:8080/rpsform/multipart

Rload the page several times. The result should change.

Note that Content-Type request header looks like "multipart/form-data; boundary=----WebKitFormBoundarykEjYByaVBXAtVdxB".


.. EOF

