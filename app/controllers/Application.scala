package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.Jsonp

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

 def getCallbackTest(someNumber:Int, callback:String) = Action.async{
    Future {
      val json = JsObject(Seq(
        "users" -> JsArray(Seq(
          JsObject(Seq(
            "name" -> JsString("Bob"),
            "age" -> JsNumber(31),
            "email" -> JsString("bob@gmail.com"),
            "someNumber" -> JsNumber(someNumber)
          ))
        ))
      ))
      Ok ( Jsonp( callback, Json.toJson(json)))
    }
  }  

}