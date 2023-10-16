package jjfactory.ticket.product

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("products")
@RestController
class ProductApi(
    private val productService: ProductService,
    private val productMapper: ProductMapper
) {

    @PostMapping
    fun post(@RequestBody request: ProductDto.Request): ResponseEntity<Unit>{
        val command = productMapper.of(request)
        productService.addProduct(command.toEntity())

        return ResponseEntity(HttpStatus.CREATED)
    }
}