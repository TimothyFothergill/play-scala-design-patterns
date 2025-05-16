package patterns.structuralpatterns

import org.scalatest._
import flatspec._
import matchers._
import patterns.structuralpatterns.adapter._
import patterns.structuralpatterns.adapter.Shape._

class AdapterSpec extends AnyFlatSpec with should.Matchers {
    "ShapeAdapter" should
        "pass the same shape if name and sides match" in {
            val result = ShapeAdapter.adaptedShape("triangle", 3, 10, 10)
            result shouldBe Triangle
        }

        it should "pass the correct shape if the name and sides don't match" in {
            val result = ShapeAdapter.adaptedShape("triangle", 0, 10, 10)
            result shouldBe Circle
        }

        it should "correctly pass a Square shape if the height and width matches with 4 sides" in {
            val result = ShapeAdapter.adaptedShape("triangle", 4, 10, 10)
            result shouldBe Square
        }

        it should "correctly pass a Rectangle shape if the height and width don't match with 4 sides" in {
            val result = ShapeAdapter.adaptedShape("triangle", 4, 5, 10)
            result shouldBe Rectangle
        }
}
