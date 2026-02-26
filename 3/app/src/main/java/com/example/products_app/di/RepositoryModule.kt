package com.example.products_app.di

import com.example.products_app.data.repository.ProductsRepository
import com.example.products_app.data.repository.ProductsRepositoryImpl
import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductsRepository(
        productsRepositoryImpl: ProductsRepositoryImpl
    ): ProductsRepository

    @Binds
    abstract fun bindRemoteDataSource(
        productsRemoteDataSourceImpl: ProductsRemoteDataSourceImpl
    ): RemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(
        productsLocalDataSource: ProductsLocalDataSource
    ): LocalDataSource
}
