package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  /**
   * Creational Patterns
   */

  def factoryMethod() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.creationalpatterns.factoryMethod())
  }
  def abstractFactory() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.creationalpatterns.abstractFactory())
  }
  def builder() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.creationalpatterns.builder())
  }
  def prototype() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.creationalpatterns.prototype())
  }
  def singleton() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.creationalpatterns.singleton())
  }

  /**
   * Structural Patterns
   */
 
  def adapter() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.structuralpatterns.adapter())
  }
  def bridge() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.structuralpatterns.bridge())
  }
  def composite() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.structuralpatterns.composite())
  }
  def decorator() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.structuralpatterns.decorator())
  }
  def facade() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.structuralpatterns.facade())
  }
  def flyweight() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.structuralpatterns.flyweight())
  }
  def proxy() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.structuralpatterns.proxy())
  }

  /**
   * Behavioral Patterns
   */

  def chainOfResponsibility() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.chainOfResponsibility())
  }
  def command() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.command())
  }
  def iterator() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.iterator())
  }
  def mediator() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.mediator())
  }
  def memento() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.memento())
  }
  def observer() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.observer())
  }
  def state() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.state())
  }
  def strategy() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.strategy())
  }
  def templateMethod() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.templateMethod())
  }
  def visitor() = Action { implicit request: Request[AnyContent] => 
    Ok(views.html.behavioralpatterns.visitor())
  }
}
