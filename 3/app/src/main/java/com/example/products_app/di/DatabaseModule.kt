package com.example.products_app.di

import android.content.Context
import com.example.products_app.data.local.ProductsDao
import com.example.products_app.data.local.ProductsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ProductsDataBase {
        return ProductsDataBase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideProductsDao(database: ProductsDataBase): ProductsDao {
        return database.getProductsDao()
    }
}
