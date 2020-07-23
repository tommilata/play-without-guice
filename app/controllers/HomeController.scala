package controllers

import play.api.mvc._

import services.HelloService

class HomeController(
  helloService: HelloService,
  override protected val controllerComponents: ControllerComponents
) extends BaseController {

  def hello = Action { implicit request: Request[AnyContent] =>
    Ok(helloService.hello)
  }
}
