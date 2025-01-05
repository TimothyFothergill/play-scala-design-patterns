package patterns.creationalpatterns

import org.scalatest._
import flatspec._
import matchers._
import patterns.creationalpatterns.factorymethod.FactoryMethodFactory

class FactoryMethodSpec extends AnyFlatSpec with should.Matchers {
    "Passing values to FactoryMethodFactory" should 
        "correctly create a new factory with FactoryMethodOne" in {
            val factory = FactoryMethodFactory(true)
            val expectedName = "Factory Method One"

            factory.factoryName shouldEqual expectedName
        }
        it should "correctly create a new factory with FactoryMethodTwo" in {
            val factory = FactoryMethodFactory(false)
            val expectedName = "Factory Method Two"

            factory.factoryName shouldEqual expectedName
        }
        it should "correctly create a new factory with a custom factoryName" in {
            val factory = FactoryMethodFactory(true, Some("Cupcake Factory"))
            val expectedName = "Cupcake Factory"

            factory.factoryName shouldEqual expectedName
        }
        it should "correctly identify any boolean value and a custom name utilises the custom factoryName" in {
            val factoryOne = FactoryMethodFactory(false, Some("Cupcake Factory"))
            val factoryTwo = FactoryMethodFactory(true, Some("Cupcake Factory"))

            factoryOne.factoryName shouldEqual factoryTwo.factoryName
        }
}