package com.route.data.api

import com.route.data.api.models.ProductsResponse
import retrofit2.http.GET

interface ProductsWebService {
    @GET("/products")
    suspend fun getProducts() : ProductsResponse
}