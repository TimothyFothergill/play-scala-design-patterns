package patterns.creationalpatterns.abstractfactory

sealed trait Animal {
    val name: String
    val legs: Int
    val foodType: FoodType

    def noise(noise: String = ""): String = "meep!"
}

sealed trait AnimalFactory {
    def createAnimal(animalType: String, animalName: String, isWild: Boolean = false): Animal
}

object GeneralAnimalFactory extends AnimalFactory {
    override def createAnimal(animalType: String, animalName: String, isWild: Boolean = false): Animal = {
        animalType.toLowerCase match {
            case "cat" => {
                isWild match {
                    case false => CatFactory.createCat(animalName)
                    case _ => CatFactory.createTiger(animalName)
                }
            }
            case "dog" => {
                isWild match {
                    case false => OtherAnimalsFactory.createDog(animalName)
                    case _ => OtherAnimalsFactory.createWolf(animalName)
                }
            }
            case "fly" => OtherAnimalsFactory.createFly(animalName)
            case "sheep" => OtherAnimalsFactory.createSheep(animalName)
        }
    }
}

object CatFactory {
    val houseCatNoise:  String = "Meow"
    val wildCatNoise:   String = "Rawr"

    def createCat(animalName: String): Animal = Cat(animalName, houseCatNoise)
    def createTiger(animalName: String): Animal = Cat(animalName, wildCatNoise)
}

object OtherAnimalsFactory {
    val dogNoise: String = "Woof"
    val wolfNoise: String = "Grrr"
    val flyNoise: String = "Bzzz"
    val sheepNoise: String = "Baaa"

    def createDog(animalName: String): Animal = Dog(animalName, dogNoise)
    def createFly(animalName: String): Animal = Fly(animalName, flyNoise)
    def createSheep(animalName: String): Animal = Sheep(animalName, sheepNoise)
    def createWolf(animalName: String): Animal = Dog(animalName, wolfNoise)
}

case class Cat(catName: String, catNoise: String) extends Animal {
    override val name: String = catName
    val legs: Int = 4
    override val foodType: FoodType = Meat()
    override def noise(catNoise: String): String = if(catNoise.nonEmpty){catNoise}else{"Meow"}
}

case class Dog(dogName: String, dogNoise: String) extends Animal {
    override val name: String = dogName
    override val legs: Int = 4
    override val foodType: FoodType = Meat()
}

case class Sheep(sheepName: String, sheepNoise: String) extends Animal {
    override val name: String = sheepName
    override val legs: Int = 4
    override val foodType: FoodType = Vegetation()
}

case class Fly(flyName: String, flyNoise: String) extends Animal {
    override val name: String = flyName
    override val legs: Int = 6
    override val foodType: FoodType = Byproducts()
}


sealed trait FoodType {
    val name: String
}
case class Byproducts() extends FoodType {
    override val name: String = "Animal byproducts"
}
case class Meat()       extends FoodType {
    override val name: String = "Meat"
}
case class Vegetation() extends FoodType {
    override val name: String = "Vegetation"
}