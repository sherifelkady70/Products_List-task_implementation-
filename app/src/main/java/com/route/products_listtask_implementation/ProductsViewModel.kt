package com.route.products_listtask_implementation

import androidx.lifecycle.ViewModel
import com.route.domain.use_case.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val usecase : ProductsUseCase
): ViewModel() {
}