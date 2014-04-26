package db

import org.scalatest.FunSuite
import scala.slick.driver.H2Driver.simple._

import db._
import model._

class DbSpec extends FunSuite {
    test("Developers should be inserted into the database") {

        val database = Database.forURL(
            "jdbc:h2:mem:test;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1",
            driver = "org.h2.Driver"
        )

		val t = TableQuery[Developers]
        database.withSession {
          implicit session =>
	          t.ddl.create
              t += Developer("Teddy Roosevelt", "teddy@example.com")
              t += Developer("Jimmy Carter", "jimmy@example.com")

              assert(t.list.length === 2)
        }
    }
}