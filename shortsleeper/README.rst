***************
Short Sleeper
***************

Sleep for a minute.

==============
Structure
==============

::

  ├── README.rst
  └── src
      └── local
          └── demo
              └── ShortSleeper.java


=============
Exercise
=============

Compile
------------

::

  $ cd src
  $ javac local/demo/ShortSleeper.java

Run
-------------

::

  $ time java local.demo.ShortSleeper
  Good night
  Good morning
  
  real    1m0.234s
  user    0m0.000s
  sys     0m0.061s
  $

.. EOF
