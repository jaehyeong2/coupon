package jjfactory.ticket.product

import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import jjfactory.ticket.ApiTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


class ProductApiTest : ApiTest() {

    @Autowired
    lateinit var productService: ProductService

    @Test
    fun `상품 등록`() {
        val request = ProductDto.Request("상품명", 20000, DiscountPolicy.NONE)

        val response = addProductRequest(request)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }

    private fun addProductRequest(request: ProductDto.Request): ExtractableResponse<Response> {
        val response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .`when`().post("/products").then().log().all().extract()
        return response
    }
}

