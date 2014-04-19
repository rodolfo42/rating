package model

import play.api.libs.json._

case class Developer(id: Option[Int], name: String, email: String) {
  def rates(p: Project) = Rating(this, p)
}

case class Project(uid: String, ratings: List[Rating] = Nil) {
  def slug = uid.split("/").toList.last
}

case class Rating(dev: Developer, proj: Project, rating: Int = 0) {
  def by(stars: Int) = Rating(dev, proj, stars)
  
  def summary = s"${dev.name} rated ${proj.slug} by $rating stars"
}

// allows instantiation without id
object Developer {
    def apply(name: String, email: String): Developer = apply(None, name, email)
}

object Project {
    implicit object ProjectFormat extends Format[Project] {
        def writes(p: Project): JsValue = {
            val s = Seq(
                "uid" -> JsString(p.uid),
                "slug" -> JsString(p.slug)
            )
            JsObject(s)
        }

        def reads(json: JsValue): JsResult[Project] = {
            JsSuccess(Project(""))
        }
    }
}