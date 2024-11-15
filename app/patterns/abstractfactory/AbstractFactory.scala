package patterns.abstractfactory

sealed trait Animal {
    val name: String

    def hasLegs(): Int
    def foodType(): FoodType
}

sealed trait CatFactory {
    val houseCatNoise:  String = "Meow"
    val wildCatNoise:   String = "Rawr"

    def createCalico(): Animal = Cat("Calico", houseCatNoise)
    def createMoggy(): Animal = Cat("Moggy", houseCatNoise)
    def createTiger(): Animal = Cat("Tiger", wildCatNoise, true)
}

case class Cat(catName: String, catNoise: String, isWild: Boolean = false) extends Animal {
    val name: String = catName
    def hasLegs(): Int = 4
    def foodType(): FoodType = Meat()
    def noise(catNoise: String): String = if(catNoise.nonEmpty){catNoise}else{"Meow"}
}

case class Dog() extends Animal {
    val name: String = "Dog"
    def hasLegs(): Int = 4
    def foodType(): FoodType = Meat()
}

case class Sheep() extends Animal {
    val name: String = "Sheep"
    def hasLegs(): Int = 4
    def foodType(): FoodType = Vegetation()
}

case class Fly() extends Animal {
    val name: String = "Fly"
    def hasLegs(): Int = 6
    def foodType(): FoodType = Byproducts()
}


sealed trait FoodType {
    val foodName: String
}
case class Byproducts() extends FoodType {
    val foodName: String = "Animal byproducts"
}
case class Meat()       extends FoodType {
    val foodName: String = "Meat"
}
case class Vegetation() extends FoodType {
    val foodName: String = "Vegetation"
}