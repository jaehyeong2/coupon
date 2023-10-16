package jjfactory.ticket.product

import org.springframework.stereotype.Component

@Component
class ProductService(
    private val productWriter: ProductWriter
) {
    fun addProduct(product: Product) {
        productWriter.write(product)
    }

}