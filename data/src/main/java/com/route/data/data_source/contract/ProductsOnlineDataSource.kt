package com.route.data.data_source.contract

import com.route.domain.model.ProductsItem

interface ProductsOnlineDataSource {
    suspend fun getProducts() : List<ProductsItem?>?
}