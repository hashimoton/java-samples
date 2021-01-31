*************************
NullPointerException
*************************

Demonstration of NullPointerException

==============
Structure
==============

::

  ├── README.rst
  └── src
      └── local
          └── demo
              └── NullAccess.java


=============
Exercise
=============

Compile
------------

::

  $ cd src
  $ javac local/demo/NullAccess.java

Run
-------------

::

  $ cd src
  $ java local.demo.NullAccess
  Exception in thread "main" java.lang.NullPointerException
          at local.demo.NullAccess.main(NullAccess.java:8)
  $

.. EOF
