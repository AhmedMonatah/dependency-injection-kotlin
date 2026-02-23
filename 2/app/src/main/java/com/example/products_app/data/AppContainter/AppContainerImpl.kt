package com.example.products_app.data.AppContainter

import android.content.Context
import com.example.di_starterapplication.data.repository.ProductsRepository
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.all.AllProductFactory
import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.local.ProductsDao
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductService
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RemoteDataSource
import com.example.products_app.data.remote.RetrofitHelper
import com.example.products_app.fav.FavProductFactory

class AppContainerImpl(context: Context) : AppContainer {

    override val dao: ProductsDao by lazy {
        val db= ProductsDataBase.getInstance(context)
        db.getProductsDao()
    }

    override val service: ProductService by lazy {
        RetrofitHelper.service
    }

    override val repo: ProductsRepository by lazy {
        val remoteDataSource: RemoteDataSource = ProductsRemoteDataSourceImpl(service)
        val localDataSource: LocalDataSource = ProductsLocalDataSource(dao)
        ProductsRepositoryImpl.getInstance(remoteDataSource, localDataSource)
    }

    override val favFactory: FavProductFactory by lazy {
        FavProductFactory(repo)
    }

    override val allFactory: AllProductFactory by lazy {
        AllProductFactory(repo)
    }
}