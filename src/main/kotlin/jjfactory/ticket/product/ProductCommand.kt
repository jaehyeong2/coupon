package jjfactory.ticket.product

class ProductCommand

{
    data class Create(
        val name: String,
        val price: Int,
        val discountPolicy: DiscountPolicy
    ){
        fun toEntity(): Product {
            return Product(
                name = name,
                price = price,
                discountPolicy = discountPolicy
            )
        }
    }
}