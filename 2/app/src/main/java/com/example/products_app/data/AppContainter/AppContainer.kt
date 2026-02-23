package com.example.products_app.data.AppContainter

import com.example.di_starterapplication.data.repository.ProductsRepository
import com.example.products_app.all.AllProductFactory
import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.local.ProductsDao
import com.example.products_app.data.remote.ProductService
import com.example.products_app.data.remote.RemoteDataSource
import com.example.products_app.fav.FavProductFactory

interface AppContainer {
    val dao: ProductsDao
    val service: ProductService
    val repo: ProductsRepository

}