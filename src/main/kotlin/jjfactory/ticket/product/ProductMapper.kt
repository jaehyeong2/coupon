package jjfactory.ticket.product

import org.springframework.stereotype.Component

@Component
class ProductMapper {
    fun of(request: ProductDto.Request): ProductCommand.Create{
        return ProductCommand.Create(
            request.name, request.price, request.discountPolicy
        )
    }
}