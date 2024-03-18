*************************
Maven Quickstart
*************************

Minimum demo of Maven archetype.

==============
Structure
==============

::

  ├── README.rst
  ├── pom.xml
  └── src
      ├── main
      │   └── java
      │       └── local
      │           └── demo
      │               └── App.java
      └── test
          └── java
              └── local
                  └── demo
                      └── AppTest.java


=============
Exercise
=============

Compile
------------

::

  $ mvn compile
  [INFO] Scanning for projects...
  ...
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time:  0.900 s
  [INFO] Finished at: 2024-03-17T23:29:16+09:00
  [INFO] ------------------------------------------------------------------------
  $


Run
-------------

::

  $ java -cp target/classes local.demo.App
  Hello World!
  $


Package
-------------

$ mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< local.demo:maven-quickstart >---------------------
[INFO] Building maven-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running local.demo.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.025 s - in local.demo.AppTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.559 s
[INFO] Finished at: 2024-03-18T00:01:50+09:00
[INFO] ------------------------------------------------------------------------
$
$ java -cp target/maven-quickstart-1.0-SNAPSHOT.jar local.demo.App
Hello World!
$


=========================
How this was generated
=========================

https://maven.apache.org/archetypes/maven-archetype-quickstart/

::

  $ mvn archetype:generate
  ...
  Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 2115: maven-archetype-quickstart
  Choose archetype:
  1: remote -> com.github.ywchang:maven-archetype-quickstart (Provide up-to-date java quickstart archetype)
  2: remote -> com.haoxuer.maven.archetype:maven-archetype-quickstart (a simple maven archetype)
  3: remote -> org.apache.maven.archetypes:maven-archetype-quickstart (An archetype which contains a sample Maven project.)
  Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 3: 3
  Choose org.apache.maven.archetypes:maven-archetype-quickstart version:
  1: 1.0-alpha-1
  2: 1.0-alpha-2
  3: 1.0-alpha-3
  4: 1.0-alpha-4
  5: 1.0
  6: 1.1
  7: 1.3
  8: 1.4
  Choose a number: 8:8
  ...
  Define value for property 'groupId': local.demo
  Define value for property 'artifactId': maven-quickstart
  Define value for property 'version' 1.0-SNAPSHOT: :
  Define value for property 'package' local.demo: :
  Confirm properties configuration:
  groupId: local.demo
  artifactId: maven-quickstart
  version: 1.0-SNAPSHOT
  package: local.demo
   Y: : y
  [INFO] ----------------------------------------------------------------------------
  [INFO] Using following parameters for creating project from Archetype: maven-archetype-quickstart:1.4
  [INFO] ----------------------------------------------------------------------------
  [INFO] Parameter: groupId, Value: local.demo
  [INFO] Parameter: artifactId, Value: maven-quickstart
  [INFO] Parameter: version, Value: 1.0-SNAPSHOT
  [INFO] Parameter: package, Value: local.demo
  [INFO] Parameter: packageInPathFormat, Value: local/demo
  [INFO] Parameter: package, Value: local.demo
  [INFO] Parameter: version, Value: 1.0-SNAPSHOT
  [INFO] Parameter: groupId, Value: local.demo
  [INFO] Parameter: artifactId, Value: maven-quickstart
  [INFO] Project created from Archetype in dir: /path/to/maven-quickstart
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time:  04:00 min
  [INFO] Finished at: 2024-03-17T23:22:16+09:00
  [INFO] ------------------------------------------------------------------------
  $


.. EOF
