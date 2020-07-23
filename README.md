# Play without Guice

An example of a Play 2 Scala app without Guice. It demonstrates manual dependency injection at compilation time using plain old constructors.

See the [ExampleApplicationLoader](app/application/ExampleApplicationLoader.scala) where the object tree of the application is built.

The example can be run locally using `sbt run`. The app will listen on http://localhost:9000.