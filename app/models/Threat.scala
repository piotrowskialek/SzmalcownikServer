package models
import play.api.libs.json.{Json, OFormat}

/**
  * Created by apiotrowski on 09.07.2017.
  */

case class Threat(
  id: Int,
  lat: Double,
  long: Double,
  created: Long
)

object JsonFormats {
  implicit val threatFormat: OFormat[Threat] = Json.format[Threat]
}

