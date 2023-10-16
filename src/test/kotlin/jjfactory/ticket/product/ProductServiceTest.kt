package jjfactory.ticket.product

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductServiceTest {

    lateinit var productService: ProductService
    lateinit var productWriter: ProductWriter
    lateinit var productRepository: ProductRepository

    @BeforeEach
    fun setUp(){
        productRepository = ProductRepository()
        productWriter = ProductWriter(productRepository)
        productService = ProductService(productWriter)
    }

    @Test
    fun `상품 등록`() {
        val command = ProductCommand("상품명", 20000, DiscountPolicy.NONE)
        productService.addProduct(command.toEntity())
    }

    class ProductService(
        private val productWriter: ProductWriter
    ) {
        fun addProduct(product: Product) {
            productWriter.write(product)
        }

    }

    data class ProductCommand(val name: String,
                              val price: Int,
                              val discountPolicy: DiscountPolicy){

        fun toEntity(): Product{
            return Product(
                name,
                price,
                discountPolicy
            )
        }
    }

    enum class DiscountPolicy {
        NONE
    }
}

class ProductWriter(
    private val productRepository: ProductRepository
) {

    fun write(product: Product) {
        productRepository.save(product)
    }

}

class ProductRepository {
    var seq : Long = 0L
    val persistence : MutableMap<Long, Product> = HashMap()

    fun save(product: Product){
        product.assignId(seq++)
        persistence.put(product.id, product)
    }
}

class Product(val name: String,
              val price: Int,
              val discountPolicy: ProductServiceTest.DiscountPolicy) {
    var id: Long = 0
    fun assignId(seq: Long) {
        this.id = seq
    }

}
