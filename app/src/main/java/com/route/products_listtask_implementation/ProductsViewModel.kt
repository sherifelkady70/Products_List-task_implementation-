package com.route.products_listtask_implementation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.common.InternetConnection
import com.route.domain.model.ProductsItem
import com.route.domain.use_case.ProductsUseCase
import com.route.domain.utils.Resource
import com.route.products_listtask_implementation.utils.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
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
                        handleResource(resource)
                    }
                }
            }
        }
    }
    private fun <T>handleResource(resource : Resource<T>){
         when(resource) {
            is Resource.Fail -> {
                when(resource.error){
                    is InternetConnection -> {
                        viewMessage.postValue(ViewMessage(
                            resource.error.message
                        ))
                    }
                    else ->{
                        viewMessage.postValue(ViewMessage(
                            resource.error.localizedMessage
                        ))
                    }
                }
            }
            is Resource.ServerError -> {
                viewMessage.postValue(ViewMessage(
                    resource.message.serverError
                ))
            }
             is Resource.Loading ->{
                 loading.postValue(true)
             }
             else -> null
        }
    }

}