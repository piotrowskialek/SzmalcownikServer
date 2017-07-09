package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._


@Singleton
class MongoController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok("xD")
  }

  def listAllofThem = Action {

    val json: JsValue = JsObject(Seq(
      "tak" -> JsString("bylo")
    ))

    Ok(json)
  }

  def addNewThreat() = Action {

    Ok("dupa")
  }



}
