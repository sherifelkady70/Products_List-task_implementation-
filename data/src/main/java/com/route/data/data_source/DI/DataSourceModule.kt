package com.route.data.data_source.DI

import com.route.data.data_source.contract.ProductsOnlineDataSource
import com.route.data.data_source.implementation.ProductsOnlineDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideProductsDataSource(impl:ProductsOnlineDataSourceImpl)
    : ProductsOnlineDataSource
}