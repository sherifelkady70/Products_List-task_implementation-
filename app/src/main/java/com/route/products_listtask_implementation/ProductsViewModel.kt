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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsUseCase : ProductsUseCase
): ViewModel() {

    val loading = MutableLiveData<Boolean>()
    private val viewMessage = MutableLiveData<ViewMessage>()
    val productsList = MutableLiveData<List<ProductsItem?>?>()

    fun getProductsList(){
        viewModelScope.launch {
            productsUseCase().collect{ resource->
                when(resource){
                    is Resource.Success ->{
                        Log.d("response is success in view model","${resource.data}")
                        productsList.postValue(resource.data)
                    }
                    else ->{
                        extractViewMessage(resource).let {
                            Log.d("in view model in extract message","$it")
                            viewMessage.postValue(it)
                        }
                    }
                }
            }
        }
    }
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