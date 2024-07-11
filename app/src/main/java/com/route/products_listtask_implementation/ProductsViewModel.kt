package com.route.products_listtask_implementation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.route.domain.common.InternetConnection
import com.route.domain.use_case.ProductsUseCase
import com.route.domain.utils.Resource
import com.route.products_listtask_implementation.utils.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.model.ProductsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsUseCase : ProductsUseCase
): ViewModel() {

    val loading = MutableLiveData<Boolean>()
     val viewMessage = MutableLiveData<ViewMessage>()
    val productsList = MutableLiveData<List<ProductsItem?>?>()

    fun getProductsList(){
        viewModelScope.launch(Dispatchers.IO){
            productsUseCase().collect{ resource->
                when(resource){
                    is Resource.Success ->{
                        productsList.postValue(resource.data)
                    }
                    else ->{
                        extractViewMessage(resource).let {
                            viewMessage.postValue(it)
                        }
                    }
                }
            }
        }
    }
    private fun <T>extractViewMessage(resource : Resource<T>) : ViewMessage? {
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