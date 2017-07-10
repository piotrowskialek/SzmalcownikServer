package controllers

import javax.inject.Inject

import play.api.i18n.MessagesApi
import play.api.libs.json.{JsObject, JsString, JsValue}
import play.api.mvc.{Action, Controller}
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}

class MainController @Inject()(val messagesApi: MessagesApi,
                               val reactiveMongoApi: ReactiveMongoApi,
                               implicit val materializer: akka.stream.Materializer)
  extends Controller with MongoController with ReactiveMongoComponents {


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
