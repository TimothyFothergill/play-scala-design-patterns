package patterns.creationalpatterns

import org.scalatest._
import flatspec._
import matchers._
import patterns.creationalpatterns.abstractfactory._

class AbstractFactorySpec extends AnyFlatSpec with should.Matchers {
    "AnimalFactory" should
        "have a createAnimal method that creates different animals" in {
            val resultOne   = GeneralAnimalFactory.createAnimal("cat", "kitty")
            val resultTwo   = GeneralAnimalFactory.createAnimal("dog", "doggo")
            val resultThree = GeneralAnimalFactory.createAnimal("fly", "buzzbuzz")
            val resultFour  = GeneralAnimalFactory.createAnimal("sheep", "baa-rry")

            resultOne.name shouldBe "kitty"
            resultOne.legs shouldEqual 4
            resultTwo.name shouldBe "doggo"
            resultTwo.legs shouldBe 4
            resultThree.name shouldBe "buzzbuzz"
            resultThree.legs shouldBe 6
            resultFour.name shouldBe "baa-rry"
            resultFour.legs shouldBe 4
        }
    it should "make a wild cat" in {
        val wildResult = GeneralAnimalFactory.createAnimal("cat", "Tigger", true)
        wildResult.makeNoise() shouldBe "Rawr"
        wildResult.makeNoise() should not be "Meow"
    }
    it should "make a wild dog" in {
        val wildResult = GeneralAnimalFactory.createAnimal("dog", "wolfie", true)
        wildResult.makeNoise() shouldBe "Grrr"
        wildResult.makeNoise() should not be "Woof"
    }
    it should "choose the relevant object type for each animal" in {
        val resultOne   = GeneralAnimalFactory.createAnimal("cat", "kitty")
        val resultTwo   = GeneralAnimalFactory.createAnimal("dog", "doggo")
        val resultThree = GeneralAnimalFactory.createAnimal("fly", "buzzbuzz")
        val resultFour  = GeneralAnimalFactory.createAnimal("sheep", "baa-rry")

        resultOne shouldBe Cat("kitty", "Meow")
        resultTwo shouldBe Dog("doggo", "Woof")
        resultThree shouldBe Fly("buzzbuzz", "Bzzz")
        resultFour shouldBe Sheep("baa-rry", "Baaa")
    }
}
