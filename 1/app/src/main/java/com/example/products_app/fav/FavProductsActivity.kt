package com.example.products_app.fav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.MyApplication
import com.example.products_app.all.AllProductFactory
import com.example.products_app.all.AllProductsViewModel
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RetrofitHelper
import com.example.products_app.servicelocator.ServiceLocatorImpl

class FavProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            val app = application as MyApplication

            val viewModel = ViewModelProvider(
                this,
                FavProductFactory(app.serviceLocator)
            )[FavProductsViewModel::class.java]

            FavProductsScreen(viewModel)
        }
    }
}

