******************************
Helpful NullPointerException
******************************

Demo of a Java improvement for NullPointerException debugging.

JEP 358: Helpful NullPointerExceptions
https://bugs.openjdk.org/browse/JDK-8220715

Release Note: Enable ShowCodeDetailsInExceptionMessages by default
https://bugs.openjdk.org/browse/JDK-8247371


==============
Structure
==============

::

  ├── README.rst
  └── src
      └── HelpfulNpe.java


=============
Exercise
=============

Compile
------------

Use Java 11.

::

  $ cd src
  $ javac HelpfulNpe.java

Run
-------------

With Java 11.

::

  $ cd src
  $ /path/to/JDK11/java HelpfulNpe
  Exception in thread "main" java.lang.NullPointerException
          at HelpfulNpe.main(HelpfulNpe.java:10) 
  $

With Java 21.

::

  $ cd src
  $ /path/to/JDK21/bin/java HelpfulNpe
  Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.HashMap.get(Object)" because "<local3>" is null
          at HelpfulNpe.main(HelpfulNpe.java:10)
  $


.. EOF
