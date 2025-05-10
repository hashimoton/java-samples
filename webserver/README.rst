***********************
Web Server
***********************

A simple HTTP server with a simple HTTP hander, based on the code at:

https://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/package-summary.html#package.description

==============
Structure
==============

::

  ├── README.rst -- This file
  └── src
      └── local
          └── demo
              ├── AdvancedHandler.java -- Advanced HTTP handler
              ├── SimpleHandler.java -- Simple HTTP handler
              └── SimpleWebServer.java -- HTTP server (main)


=============
Exercise
=============

Compile
------------

::

  $ cd src
  $ javac local/demo/SimpleWebServer.java
  $ javac local/demo/SimpleHandler.java

Run
------------

::

  $ cd src
  $ java local.demo.SimpleWebServer
  Server started

Verify
-------------

From another terminal, access http://localhost:8000 with curl.

::

  $ curl http://localhost:8000
  Simple
  $

At the same time, the HTTP server should log requested/responded messages.

::

  $ java local/demo/SimpleWebServer
  Server started
  Handler started
  Handler ended

If you repeart the curl command or access the URL with a browser, multiple messages will be logged.

To stop the HTTP server, press Ctrl+C.


======================
Advanced sample
======================

There is another sample handler with additional behaviors, such as logging the requested path, sleeping several seconds , and adding CcontentType header.

Switch the handler
--------------------

Modify simpleWebServer.java to use AdvancedHandler.


Before::

  server.createContext("/", new SimpleHandler());

After::

  server.createContext("/", new AdvancedHandler());


Recompile
----------------

::

  $ javac local/demo/SimpleWebServer.java
  $ javac local/demo/AdvancedHandler.java


Restart the HTTP server
-------------------------

::

  $ java local.demo.SimpleWebServer
  Server started


Access the HTTP server
------------------------

::

  $ curl -v http://localhost:8000/demo
  *   Trying 127.0.0.1:8000...
  * Connected to localhost (127.0.0.1) port 8000 (#0)
  > GET /demo HTTP/1.1
  > Host: localhost:8000
  > User-Agent: curl/7.81.0
  > Accept: */*
  >
  * Mark bundle as not supporting multiuse
  < HTTP/1.1 200 OK
  < Date: Sat, 10 May 2025 04:43:57 GMT
  < Content-type: text/html
  < Content-length: 22
  <
  <html>Advanced</html>
  * Connection #0 to host localhost left intact
  $


Logging
------------------

See the path of the requested URL in the stdout.

::

  Handler begin
  path = /demo
  0
  1
  2
  3
  4
  5
  6
  7
  8
  9
  Handler end


Further testing
-----------------

While waiting for the response for the curl's request, access the HTTP server with a browser.
Take a theread dump during parallel requests.

::

  $ pgrep -a java
  2291 java local.demo.SimpleWebServer
  $
  $ jstack 2291
  $
  $ kill -3 2291


.. EOF

