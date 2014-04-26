package controllers

import play.api._
import play.api.mvc._
import model._
import json._
import play.api.libs.json._

object RatingController extends Controller with SpeaksJson {

    def index = Action {
        val projects = db.DB.allProjects
        Ok(Json.toJson(projects))
    }
}