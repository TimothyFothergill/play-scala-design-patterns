package patterns.factorymethod

trait FactoryMethod {
    def factoryName: String
}

// Concrete implementations of FactoryMethod
class FactoryMethodOne extends FactoryMethod {
    val factoryName = "Factory Method One"
}

class FactoryMethodTwo extends FactoryMethod {
    val factoryName = "Factory Method Two"
}

// Create a separate factory object for the factory method logic
object FactoryMethodFactory {
    def apply(factoryChoice: Boolean): FactoryMethod = factoryChoice match {
        case true   => new FactoryMethodOne()
        case false  => new FactoryMethodTwo()
    }
}
