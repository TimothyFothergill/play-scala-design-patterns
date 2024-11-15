package patterns.factorymethod

sealed trait FactoryMethod {
    val factoryName: String
}

// Concrete implementations of FactoryMethod
case class FactoryMethodOne() extends FactoryMethod {
    val factoryName = "Factory Method One"
    
}

case class FactoryMethodTwo() extends FactoryMethod {
    val factoryName = "Factory Method Two"
}

case class FactoryMethodWithString(factoryString: String) extends FactoryMethod {
    val factoryName: String = factoryString
}

// Create a separate factory object for the factory method logic
object FactoryMethodFactory {
    def apply(factoryChoice: Boolean, additionalChoices: Option[String] = None): FactoryMethod = { 
        (factoryChoice, additionalChoices) match {
            case (true, Some(string))  => FactoryMethodWithString(string)
            case (true, None)          => FactoryMethodOne()
            case (false, Some(string)) => FactoryMethodWithString(string)
            case (false, None)         => FactoryMethodTwo()
        }
    }
}
