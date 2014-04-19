package model

case class Developer(id: Option[Int], name: String, email: String) {
  def rates(p: Project) = Rating(this, p)
  def rates(stars: Int) = Rating(this, Project(""), stars)
}

case class Project(uid: String, rs: List[Rating] = Nil) {
  val ratings = for(
      rating <- rs
    ) yield Rating(rating.dev, this, rating.stars)
  def slug = uid.split("/").toList.last
}

case class Rating(dev: Developer, proj: Project = Project(""), stars: Int = 0) {
  def by(stars: Int) = Rating(dev, proj, stars)
  
  def summary = s"${dev.name} rated ${proj.slug} by $stars stars"
}

// allows instantiation without id
object Developer {
    def apply(name: String, email: String): Developer = apply(None, name, email)
}

object Rating {
    def toJson(r: Rating): (Developer, Int) = (r.dev, r.stars)
}