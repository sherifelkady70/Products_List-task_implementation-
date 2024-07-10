package com.route.data

import com.google.gson.Gson
import com.route.data.api.model.ProductResponse
import com.route.domain.common.InternetConnection
import com.route.domain.common.ServerErrorDC
import retrofit2.HttpException
import java.io.IOException

suspend fun <T>executeAPI(callAPI : suspend ()->T) : T {
    try {
        val response = callAPI.invoke()
        return response
    }catch (ex: HttpException) {
        if(ex.code() in 400..600){
            val serverResponse = ex.response()?.errorBody()?.string()
            val response = Gson().fromJson<ProductResponse<Any>>(serverResponse,ProductResponse::class.java)
            throw ServerErrorDC(response.statusMsg,response.message,ex)
        }
        throw ex
    }catch (ex: IOException){
        throw InternetConnection(ex)
    }catch (ex:Exception){
        throw ex
    }

}