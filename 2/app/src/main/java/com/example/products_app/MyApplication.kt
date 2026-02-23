package com.example.products_app


import android.app.Application
import com.example.products_app.data.AppContainter.AppContainer
import com.example.products_app.data.AppContainter.AppContainerImpl

class MyApplication : Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainerImpl(this)
    }
}