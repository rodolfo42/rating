package controllers

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class RatingControllerSpec extends Specification {
  "render a json in the index action" in {
    val result = controllers.RatingController.index()(FakeRequest())
    
    status(result) must equalTo(OK)
    contentAsString(result) must contain("jquery")
  }
}