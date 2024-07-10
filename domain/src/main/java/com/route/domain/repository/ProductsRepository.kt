package com.route.domain.repository

import com.route.domain.model.ProductsItem
import com.route.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts()  : Flow<Resource<List<ProductsItem?>?>>
}