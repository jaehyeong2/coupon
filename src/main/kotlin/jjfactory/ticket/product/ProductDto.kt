package jjfactory.ticket.product

class ProductDto{
    data class Request(
        val name: String,
        val price: Int,
        val discountPolicy: DiscountPolicy
    )
}




