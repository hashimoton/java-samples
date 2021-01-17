***********************
Web Server
***********************

A simple HTTP server with a simple HTTP hander, based on the code at:

https://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/package-summary.html#package.description

==============
Structure
==============

  ├── README.rst -- This file
  └── src
      └── local
          └── demo
              ├── SimpleHandler.java -- HTTP handler
              └── SimpleServer.java -- HTTP server (main)


=============
Exercise
=============

Compile
------------

::

  $ cd src
  $ javac local/demo/SimpleServer.java

Run
------------

::

  $ cd src
  $ java local.demo.SimpleServer
  Started

Verify
-------------

From another terminal, access http://localhost:8000 .

::

  $ curl http://localhost:8000
  Simple Web Server
  $

At the same time, the HTTP server should log requested/responded messages.

::

  $ java local/demo/SimpleServer
  Started
  Requested
  Responded

If you access the URL with a browser, multiple messages will be logged at a time.


.. EOF
