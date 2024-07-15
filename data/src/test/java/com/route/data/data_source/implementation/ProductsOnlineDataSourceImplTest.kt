package com.route.data.data_source.implementation

import com.route.data.api.ProductsWebService
import com.route.data.data_source.contract.ProductsOnlineDataSource
import com.route.data.api.models.ProductsItem
import com.route.data.api.models.ProductsResponse
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class ProductsOnlineDataSourceImplTest{
    lateinit var datasource : ProductsOnlineDataSource
    //fake object
    val webService = mockk<ProductsWebService>()

    @Before
    fun setup(){
        datasource = ProductsOnlineDataSourceImpl(webService)
    }
    @Test
    fun `get list of products when call` () {
        val productsResponse = ProductsResponse()
        //fake behavior
        val response = coEvery { webService.getProducts()} returns productsResponse
        datasource.getProducts()
    }
}