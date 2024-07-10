package com.route.data.api.DI

import android.util.Log
import com.route.data.api.ProductsWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object WebServiceModule {

    @Provides
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor{
            Log.e("API",it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    @Provides
    fun provideOkHttpClint(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient
            .Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .build()
    }
    @Provides
    fun provideGson():GsonConverterFactory{
        return GsonConverterFactory.create()
    }
    @Provides
    fun provideRetrofit(gson:GsonConverterFactory,
                        clint:OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(gson)
            .client(clint)
            .build()
    }
    @Provides
    fun provideWebService(retrofit: Retrofit)  : ProductsWebService{
        return retrofit.create(ProductsWebService::class.java)
    }
}