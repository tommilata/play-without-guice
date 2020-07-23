package application

import play.api.ApplicationLoader.Context
import play.api.http.DefaultHttpErrorHandler
import play.api.routing.Router
import play.api.{
  Application,
  ApplicationLoader,
  BuiltInComponentsFromContext,
  LoggerConfigurator
}
import play.filters.HttpFiltersComponents

import controllers.HomeController
import router.Routes
import services.HelloServiceImpl

class ExampleApplicationLoader extends ApplicationLoader {
  override def load(context: ApplicationLoader.Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment, context.initialConfiguration, Map.empty)
    }
    new ExampleComponents(context).application
  }
}

class ExampleComponents(context: Context)
    extends BuiltInComponentsFromContext(context)
    with HttpFiltersComponents {

  private val helloService = new HelloServiceImpl(configuration)
  private val homeController =
    new HomeController(helloService, controllerComponents)

  override def router: Router =
    new Routes(new DefaultHttpErrorHandler, homeController)
}
