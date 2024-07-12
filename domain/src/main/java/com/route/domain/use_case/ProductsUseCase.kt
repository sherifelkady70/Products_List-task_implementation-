package com.route.domain.use_case

import android.util.Log
import com.route.domain.model.ProductsItem
import com.route.domain.repository.ProductsRepository
import com.route.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository,
){
    suspend operator fun invoke() : Flow<Resource<List<ProductsItem?>?>> {
        return productsRepository.getProducts()
    }
}