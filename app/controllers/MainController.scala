package controllers

import javax.inject.Inject

import models.Threat
import play.api.i18n.MessagesApi
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._
import play.api.mvc.{Action, Controller}
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.api.Cursor
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.bson.BSONDocument

import scala.concurrent.Future


class MainController @Inject()(val messagesApi: MessagesApi,
                               val reactiveMongoApi: ReactiveMongoApi,
                               implicit val materializer: akka.stream.Materializer)
  extends Controller with MongoController with ReactiveMongoComponents {

  import models.Threat.threatJsonFormat

  def collection2: JSONCollection = db.collection[JSONCollection]("threats")
  def collection: BSONCollection = db[BSONCollection]("threats")



  def index = Action {

    import models.Threat.threatJsonFormat

    val dto = Threat(1,1.0,1.0,123)

    collection2.insert(dto)

    val query = BSONDocument()
    val cursor: Cursor[BSONDocument] = collection.find(query).cursor[BSONDocument]
    val futureList: Future[List[BSONDocument]] = cursor.collect[List]()

    val json: JsValue = JsObject(Seq(
    "tak" -> JsString("bylo")
    ))

    Ok(json)
  }

  def post = Action {
    Ok("xD")
  }


}
