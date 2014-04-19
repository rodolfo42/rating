package controllers

import play.api._
import play.api.mvc._
import model._
import json.JsonConverter._

object RatingController extends Controller {

    def index = Action {
        val projects = db.DB.allProjects
        Ok(toJson(projects))
    }
}
