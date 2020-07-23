package controllers

import play.api.mvc._

class HomeController(
  override protected val controllerComponents: ControllerComponents
) extends BaseController {

  def hello = Action { implicit request: Request[AnyContent] =>
    Ok("hello")
  }
}
