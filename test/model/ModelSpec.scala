package model

import org.scalatest.FunSuite

class ModelSpec extends FunSuite {

    test("project rating should obey the stars given") {
        val john = Developer("John", "john@example.com")
        val mike = Developer("Mike", "mike@example.com")
        val jquery = Project("jquery/jquery", 
        	List(
        		Rating(john, 3),
        		Rating(mike, 5)
        	)
      	)

        assert(jquery.stars === 4.0d)
    }
}