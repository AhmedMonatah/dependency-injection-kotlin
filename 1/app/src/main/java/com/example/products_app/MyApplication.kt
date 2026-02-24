package com.example.products_app



import android.app.Application
import com.example.products_app.servicelocator.ServiceLocatorImpl


class MyApplication : Application() {

    lateinit var serviceLocator: ServiceLocatorImpl

    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocatorImpl(this)
    }
}