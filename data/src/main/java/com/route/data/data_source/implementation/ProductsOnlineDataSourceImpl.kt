package com.route.data.data_source.implementation

import com.route.data.data_source.contract.ProductsOnlineDataSource
import com.route.domain.model.ProductsItem

class ProductsOnlineDataSourceImpl : ProductsOnlineDataSource {
    override suspend fun getProducts(): List<ProductsItem?>? {
        TODO("Not yet implemented")
    }
}