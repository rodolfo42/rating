package json

import model._
import play.api.libs.json._

object JsonConverter {
    def toJson(p: Project): JsValue = {
        val s = Seq(
            "uid" -> JsString(p.uid),
            "slug" -> JsString(p.slug)
        )
        JsObject(s)
    }

    def toJson(ps: Seq[Project]): JsValue = 
        Json.toJson(ps.map(toJson))
}
