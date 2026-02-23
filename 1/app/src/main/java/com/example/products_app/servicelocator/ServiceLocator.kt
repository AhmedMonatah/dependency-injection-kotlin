package com.example.products_app.servicelocator

import android.content.Context
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.all.AllProductFactory
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RetrofitHelper
import com.example.products_app.fav.FavProductFactory

interface ServiceLocator{
    fun <T> getDependency(required: DEPENDANCY): T

}
class ServiceLocatorImpl(private val ctx: Context): ServiceLocator {
    override fun <T> getDependency(required: DEPENDANCY): T {
        return when (required) {
            DEPENDANCY.PRODUCT_SERVICE -> RetrofitHelper.service as T
            DEPENDANCY.PRODUCT_DAO -> ProductsDataBase.getInstance(ctx ).getProductsDao() as T
            DEPENDANCY.LOCAL_SOURCE -> ProductsLocalDataSource(this) as T
            DEPENDANCY.REMOTE_SOURCE -> ProductsRemoteDataSourceImpl(this) as T
            DEPENDANCY.REPOSITORY -> ProductsRepositoryImpl.getInstance(this) as T
            DEPENDANCY.ALL_FACTORY -> AllProductFactory(this) as T
            DEPENDANCY.FAV_FACTORY -> FavProductFactory(this) as T
            else -> throw Exception("invalid dependency")
        }
    }
}