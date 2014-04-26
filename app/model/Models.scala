package model

case class Developer(
	name: String, 
	email: String, 
	id: Option[Int] = None) {
  def rates(stars: Int) = Rating(this, stars)
}

case class Project(uid: String, ratings: List[Rating] = Nil) {
  def slug = uid.split("/").toList.last
  def stars = ratings.map(_.stars).sum / ratings.length
}

case class Rating(
	dev: Developer,
	stars: Int = 0) {

  def by(stars: Int) = 
  	Rating(dev, stars)
}

object Rating {
    def toJson(r: Rating): (Developer, Int) = 
    	(r.dev, r.stars)
}