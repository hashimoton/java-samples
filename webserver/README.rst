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
              ├── SimpleHandler.java -- HTTP handler
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


.. EOF

