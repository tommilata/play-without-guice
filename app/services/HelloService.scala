package services
import play.api.Configuration

trait HelloService {
  def hello: String = s"$greeting world"

  protected def greeting: String
}

class HelloServiceImpl(configuration: Configuration) extends HelloService {
  override protected def greeting: String =
    configuration.get[String]("greeting")
}
