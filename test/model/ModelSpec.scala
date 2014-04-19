package model

import org.scalatest._

class ModelSpec extends FunSuite {

    test("project rating should obey the stars given") {
        val john = Developer("John", "john@example.com")
        val jquery = Project("jquery/jquery")
        val rating = john rates jquery by 4

        assert(rating.summary === "John rated jquery by 4 stars")
    }
}