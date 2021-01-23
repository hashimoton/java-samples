*******************
Another Package
*******************

A Java class belongs to another package.

==============
Structure
==============

::

  ├── README.rst
  └── src
      ├── com
      │   └── example
      │       └── Visitor.java
      └── local
          └── demo
              └── Entrance.java


=============
Exercise
=============

Compile
------------

::

  $ cd src
  $ javac javac local/demo/Entrance.java

Run
-------------

::

  $ cd src
  $ java local.demo.Entrance
  Hello, I am One.
  $


.. EOF
