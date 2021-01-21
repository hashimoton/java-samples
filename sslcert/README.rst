**************************
Show SSL Certificates
**************************

Show SSL certificates of an HTTPS URL

==============
Structure
==============

::

  └── local
      └── demo
          └── SslCert.java



=============
Exercise
=============

Compile
------------

::

  $ cd src
  $ javac local/demo/SslCert.java

Run
-------------

::

  $ cd src
  $ java local.demo.SslCert https://example.com/
  Connected
  *** Certificate 0***
  [
  [
    Version: V3
    Subject: CN=www.example.org, O=Internet Corporation for Assigned Names and Num
bers, L=Los Angeles, ST=California, C=US
  ...
  $

.. EOF
