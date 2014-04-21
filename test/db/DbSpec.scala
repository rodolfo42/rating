package db

import org.scalatest.FunSuite
import scala.slick.driver.H2Driver.simple._

class DbSpec extends Funsuite {
    test("Foo should Bar") {

        val conn = SlickDatabase.forURL(
            "jdbc:h2:mem:test;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1",
            driver = "org.h2.Driver"
        )

        conn.withSession {
          import scala.slick.session.Database.threadLocalSession
          val t = Projects
          t.ddl.create
        }
    }
}