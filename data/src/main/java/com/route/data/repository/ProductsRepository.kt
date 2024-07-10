package com.route.data.repository

import com.route.data.data_source.contract.ProductsOnlineDataSource
import com.route.domain.model.ProductsItem
import com.route.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val datasource : ProductsOnlineDataSource
): ProductsRepository {
    override suspend fun getProducts(): Flow<List<ProductsItem?>?> {
        return datasource.getProducts()
    }
}