package patterns.creationalpatterns.singleton

object ProductsSingleton {
    private var productSeq: Seq[Product]    = Seq(
        Product(0,"Potatoes (2kg)", 1.45),
        Product(1,"Carrot", 0.25),
        Product(2,"Fizzy Drink", 1.99),
        Product(3,"Cereal Flakes (Bigger Box)", 2.55)
    )

    def getProducts: Seq[Product] = productSeq

    def addProduct(newProduct: Product): Unit = {
        productSeq = productSeq :+ newProduct
    }
    def listProducts: String = {
        productSeq.map(_.productName).mkString("<br>")
    }
    def removeProduct(productId: Int): Unit = {
        productSeq = productSeq.filterNot(_.productId == productId)
    }
}

case class Product(
    productId: Int,
    productName: String,
    productPrice: Float
)