package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import model._

object RatingController extends Controller {

    def index = Action {
        val projects = db.DB.allProjects
        Ok(Json.toJson(projects.map(Json.toJson(_))))
    }
}