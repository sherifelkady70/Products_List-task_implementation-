package com.route.data.data_source.implementation

import com.route.data.api.ProductsWebService
import com.route.data.data_source.contract.ProductsOnlineDataSource
import io.mockk.MockK
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class ProductsOnlineDataSourceImplTest{
    lateinit var datasource : ProductsOnlineDataSource
    val webService = mockk<ProductsWebService>()

    @Before
    fun setup(){
        datasource = ProductsOnlineDataSourceImpl(webService)
    }
    @Test
    fun `get list of products when call` (){

    }
}