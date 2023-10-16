package jjfactory.ticket.product

class Product(val name: String,
              val price: Int,
              val discountPolicy: DiscountPolicy
) {
    var id: Long = 0
    fun assignId(seq: Long) {
        this.id = seq
    }

}