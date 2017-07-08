package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._


@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {

    val json: JsValue = JsObject(Seq(
      "tak" -> JsString("bylo")
    ))

    Ok(json)
  }

}
