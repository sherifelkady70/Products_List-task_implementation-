package com.route.data.api

import com.route.data.api.new_models.NewResponse
import retrofit2.http.GET

interface ProductsWebService {
    @GET("/products")
    suspend fun getProducts() : NewResponse
}