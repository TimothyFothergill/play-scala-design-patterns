package patterns.creationalpatterns.abstractfactory

sealed trait Animal {
    val name: String
    val legs: Int
    val foodType: FoodType

    def noise(noise: String): String = "meep!"
}

sealed trait CatFactory {
    val houseCatNoise:  String = "Meow"
    val wildCatNoise:   String = "Rawr"

    def createCalico(): Animal = Cat("Calico", houseCatNoise)
    def createMoggy(): Animal = Cat("Moggy", houseCatNoise)
    def createTiger(): Animal = Cat("Tiger", wildCatNoise, true)
}

sealed trait OtherAnimalsFactory {
    val dogNoise: String = "Woof"
    val flyNoise: String = "Bzzz"
    val sheepNoise: String = "Baaa"

    def createDog(): Animal = Dog("Golden Retriever", dogNoise)
    def createFly(): Animal = Fly("Buzz", flyNoise)
    def createDog(): Animal = Sheep("Fleece Witherspoon", sheepNoise)
}

case class Cat(catName: String, catNoise: String, isWild: Boolean = false) extends Animal {
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
    val foodName: String
}
case class Byproducts() extends FoodType {
    override val foodName: String = "Animal byproducts"
}
case class Meat()       extends FoodType {
    override val foodName: String = "Meat"
}
case class Vegetation() extends FoodType {
    override val foodName: String = "Vegetation"
}