package jjfactory.ticket.product

import org.springframework.stereotype.Component

@Component
class ProductWriter(
    private val productRepository: ProductRepository
) {

    fun write(product: Product) {
        productRepository.save(product)
    }

}