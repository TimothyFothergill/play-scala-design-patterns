package patterns.creationalpatterns

import org.scalatest._
import flatspec._
import matchers._
import patterns.creationalpatterns.prototype._

class PrototypeSpec extends AnyFlatSpec with should.Matchers {  
    "ShapePrototype" should "create a clone of a prototype" in {
        val clonedShape = ShapePrototype.clone()
        clonedShape.shapeDescription shouldBe "A Red Square"
    }
}
