package jjfactory.ticket.product

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class ProductService(
    private val productWriter: ProductWriter
) {
    fun addProduct(product: Product) {
        productWriter.write(product)
    }

}