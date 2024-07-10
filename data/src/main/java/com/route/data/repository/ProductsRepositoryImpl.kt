package com.route.data.repository

import com.route.data.data_source.contract.ProductsOnlineDataSource
import com.route.data.toFlow
import com.route.domain.model.ProductsItem
import com.route.domain.repository.ProductsRepository
import com.route.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val datasource : ProductsOnlineDataSource
): ProductsRepository {
    override suspend fun getProducts(): Flow<Resource<List<ProductsItem?>?>> {
        return toFlow {
            datasource.getProducts()
        }
    }
}