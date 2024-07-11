package com.route.data.data_source.implementation

import android.util.Log
import com.route.data.api.ProductsWebService
import com.route.data.data_source.contract.ProductsOnlineDataSource
import com.route.data.executeAPI
import com.route.domain.model.ProductsItem
import javax.inject.Inject

class ProductsOnlineDataSourceImpl @Inject constructor(
    private val webService : ProductsWebService
): ProductsOnlineDataSource {
    override suspend fun getProducts(): List<ProductsItem?>? {
        Log.d("before execute API fun in data source","${webService.getProducts().data}")
        val response = executeAPI { webService.getProducts() }
        Log.d("in data source","${response.data}")
        return response.data
    }
}