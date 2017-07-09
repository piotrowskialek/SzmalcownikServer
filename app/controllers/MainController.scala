package controllers

import javax.inject._

import play.api.libs.json._
import play.api.mvc._
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}

//import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}

@Singleton
class MainController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc)
//    with ReactiveMongoComponents
//    with MongoController
{

//  override def reactiveMongoApi: ReactiveMongoApi = ???

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
