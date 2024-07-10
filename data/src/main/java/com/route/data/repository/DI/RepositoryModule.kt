package com.route.data.repository.DI

import com.route.data.repository.ProductsRepositoryImpl
import com.route.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideProductsRepository(impl:ProductsRepositoryImpl)
    : ProductsRepository
}