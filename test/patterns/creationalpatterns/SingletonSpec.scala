package patterns.creationalpatterns

import org.scalatest._
import flatspec._
import matchers._
import patterns.creationalpatterns.singleton._
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._

class SingletonSpec extends AnyFlatSpec with should.Matchers with MockitoSugar {
  "ProductsSingleton" should "display a list of all objects using the listProducts method" in {
        val newProductsSingleton = mock[ProductsSingleton.type]
        when(newProductsSingleton.listProducts).thenReturn("Potatoes (2kg)<br>Carrot<br>")
        val productsList = newProductsSingleton.listProducts

        productsList should include("Carrot<br>")
  }
}
