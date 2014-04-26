package db

import scala.slick.driver.H2Driver.simple._
import model._

class Developers(tag: Tag) extends Table[Developer](tag, "DEVELOPER") {
  // Auto Increment the id primary key column
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  // The name can't be null
  def name = column[String]("NAME", O.NotNull)
  // E-mail can't be null
  def email = column[String]("EMAIL", O.NotNull)
  // the * projection (e.g. select * ...) auto-transform the tupled column values to / from a User
  def * = (name, email, id.?) <> (Developer.tupled, Developer.unapply)
}