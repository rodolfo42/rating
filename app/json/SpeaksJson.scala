package json

import model._
import play.api.libs.json._
import play.api.libs.functional.syntax._

trait SpeaksJson {
    implicit val developerWrites: Writes[Developer] = (
        (JsPath \ "name").write[String] and
        (JsPath \ "email").write[String] and
        (JsPath \ "id").writeNullable[Int]
    )(unlift(Developer.unapply))

    implicit val ratingWrites: Writes[Rating] = (
        (JsPath \ "developer").write[Developer] and
        (JsPath \ "stars").write[Int]
    )(Rating.toJson _)

    implicit val projectWrites: Writes[Project] = (
        (JsPath \ "guid").write[String] and
        (JsPath \ "ratings").write[Seq[Rating]]
    )(unlift(Project.unapply))
}