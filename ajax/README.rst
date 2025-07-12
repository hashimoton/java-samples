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
  ├── remotequiz.jsp -- Call remote data
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
  # ln -s /path/to/ajax .
 

Get data from same origin
---------------------------

With a browser, open a web page.

http://localhost:8080/ajax/localquiz.jsp

Click "See Answer" to display the data retrived from same origin.
 
http://localhost:8080/ajax/answer.xml


Get data from different origin
--------------------------------

Map localhost to another host
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

You can modify /etc/hosts file or create a browser shortcut.

Chrome shortcut example to direct http://example.com:8080 to http://127.0.0.1:8080

::

  "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --incognito --user-data-dir=C:\path\to\chrome-profiles\internal-test --host-resolver-rules="MAP example.com:8080 127.0.0.1:8080"

Calling localhost from localhost
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Access another page.

http://localhost:8080/ajax/remotequiz.jsp

Confirm that the input field has the localhost URL, and click "See Answer."

http://localhost:8080/ajax/answer.xml

The answer "A" appears.

Calling example.com from localhost
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Reload the page.

Change the input field to:

http://example.com:8080/ajax/answer.xml

"See Answer" results a failure. Browser console tells an error::

  Access to XMLHttpRequest at 'http://example.com:8080/ajax/answer.xml' from origin 'http://localhost:8080' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource. 

Although the server receives the request and responds with 200 OK::

  AnswerServlet: doGet for http://example.com:8080/ajax/answer.xml


Calling example.com from example.com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Access the page using the example.com domain.

http://example.com:8080/ajax/remotequiz.jsp

Confirm that the input field has the localhost URL, and click "See Answer."

http://localhost:8080/ajax/answer.xml

The request is invoked but the JavaScript cannot process the response.


With Access-Control-Allow-Origin header for example.com
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Change the input field to:                                                                                                                                                                                                                      http://localhost:8080/ajax/answer.xml?cors=true

The answer "A" appears.


==================
Further studies
==================

- Use POST request
- Implement doOptions() for preflight OPTIONS requests
- Rewrite the JSP files with Fetch API


===============
References
===============

https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/CORS

https://fetch.spec.whatwg.org/#cross-origin-resource-policy-header


.. EOF

