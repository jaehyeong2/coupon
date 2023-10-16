package jjfactory.ticket.product

import org.springframework.stereotype.Repository

@Repository
class ProductRepository {
    var seq : Long = 0L
    val persistence : MutableMap<Long, Product> = HashMap()

    fun save(product: Product){
        product.assignId(seq++)
        persistence.put(product.id, product)
    }
}