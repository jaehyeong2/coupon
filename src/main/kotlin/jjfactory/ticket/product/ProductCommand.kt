package jjfactory.ticket.product

data class ProductCommand(val name: String,
                          val price: Int,
                          val discountPolicy: DiscountPolicy
){

    fun toEntity(): Product {
        return Product(
            name,
            price,
            discountPolicy
        )
    }
}