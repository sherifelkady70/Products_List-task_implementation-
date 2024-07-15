package com.route.data.data_source.implementation

import com.route.data.api.ProductsWebService
import com.route.data.data_source.contract.ProductsOnlineDataSource
import com.route.data.api.models.ProductsItem
import com.route.data.api.models.ProductsResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
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
    fun `get list of products when call` () = runTest {
        val productsResponse = ProductsResponse(
            products = listOf(
                ProductsItem(id = 1), ProductsItem(id = 1), ProductsItem(id = 1)
            )
        )
        //fake behavior
        coEvery { webService.getProducts()} returns productsResponse
        val productsData = datasource.getProducts()
        assert(productsData?.size==3)
    }
}