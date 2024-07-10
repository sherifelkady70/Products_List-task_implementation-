package com.route.data.repository

import com.route.domain.model.ProductsItem
import com.route.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class ProductsRepository : ProductsRepository {
    override suspend fun getProducts(): Flow<List<ProductsItem?>?> {
        TODO("Not yet implemented")
    }
}