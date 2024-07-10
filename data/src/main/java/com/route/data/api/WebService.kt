package com.route.data.api

import com.route.data.api.model.ProductResponse
import com.route.domain.model.ProductsItem
import retrofit2.http.GET

interface WebService {
    @GET("/products")
    suspend fun getProducts() : ProductResponse<List<ProductsItem?>?>
}