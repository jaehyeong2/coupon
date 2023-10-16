package jjfactory.ticket.product

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    lateinit var productService: ProductService

    @Test
    fun `상품 등록`() {
        val command = ProductCommand.Create("상품명", 20000, DiscountPolicy.NONE)
        productService.addProduct(command.toEntity())
    }
}

