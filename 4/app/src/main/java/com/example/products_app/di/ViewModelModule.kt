package com.example.products_app.di

import com.example.products_app.all.AllProductsViewModel
import com.example.products_app.fav.FavProductsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AllProductsViewModel(get()) }
    viewModel { FavProductsViewModel(get()) }
}
