package com.route.domain.repository

import com.route.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts()  : Flow<List<ProductsItem?>?>
}