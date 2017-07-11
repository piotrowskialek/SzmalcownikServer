package controllers

import javax.inject.Inject

import play.api.i18n.MessagesApi
import play.api.libs.json.{JsObject, JsString, JsValue}
import play.api.mvc.{Action, AnyContent, Controller}
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}

import play.api.Logger
import play.api.mvc.{ Action, Controller }
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._


import reactivemongo.play.json.collection.JSONCollection
import models._

import reactivemongo.api.Cursor

import scala.concurrent.Future


class MainController @Inject()(val messagesApi: MessagesApi,
                               val reactiveMongoApi: ReactiveMongoApi,
                               implicit val materializer: akka.stream.Materializer)
  extends Controller with MongoController with ReactiveMongoComponents {

  def collection: JSONCollection = db.collection[JSONCollection]("threats")

  def create: Action[AnyContent] = Action.async {
    val user = Threat(1, 1.0, 1.0, 123456789)
    val futureResult = collection.insert(user)
    futureResult.map(_ => Ok)
  }


  def createFromJson: Action[JsValue] = Action.async(parse.json) { request =>

    request.body.validate[Threat].map { threat =>
      collection.insert(threat).map { lastError =>
        Logger.debug(s"Successfully inserted with LastError: $lastError")
        Created
      }
    }.getOrElse(Future.successful(BadRequest("invalid json")))
  }

  def findByName(id: Int): Action[AnyContent] = Action.async {

    val cursor: Cursor[Threat] = collection.
      find(Json.obj("id" -> id)).
      sort(Json.obj("created" -> -1)).
      cursor[Threat]

    val futureUsersList: Future[List[Threat]] = cursor.collect[List]()

    futureUsersList.map { persons =>
      Ok(persons.toString)
    }
  }


  def index = Action {


    val json: JsValue = JsObject(Seq(
      "tak" -> JsString("bylo")
    ))

    Ok(json)
  }

  def post = Action {
    Ok("xD")
  }


}
