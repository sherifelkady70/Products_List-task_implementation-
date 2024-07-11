package com.route.products_listtask_implementation

import androidx.lifecycle.ViewModel
import com.route.domain.common.InternetConnection
import com.route.domain.use_case.ProductsUseCase
import com.route.domain.utils.Resource
import com.route.products_listtask_implementation.utils.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val usecase : ProductsUseCase
): ViewModel() {



    fun <T>extractViewMessage(resource : Resource<T>) : ViewMessage? {
        return when(resource) {
            is Resource.Fail -> {
                when(resource.error){
                    is InternetConnection -> {
                        ViewMessage(
                            resource.error.message
                        )
                    }
                    else ->{
                        ViewMessage(
                            resource.error.localizedMessage
                        )
                    }
                }
            }
            is Resource.ServerError -> {
                ViewMessage(
                    resource.message.serverError
                )
            }
            else -> null
        }
    }

}