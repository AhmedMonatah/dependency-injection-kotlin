package com.example.products_app.di

import com.example.di_starterapplication.data.repository.ProductsRepository
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RemoteDataSource
import com.example.products_app.data.remote.RetrofitHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { ProductsDataBase.getInstance(androidContext()) }
    single { get<ProductsDataBase>().getProductsDao() }

    single { RetrofitHelper.service }

    single<RemoteDataSource> { ProductsRemoteDataSourceImpl(get()) }
    single<LocalDataSource> { ProductsLocalDataSource(get()) }

    single<ProductsRepository> { ProductsRepositoryImpl(get(), get()) }
}
