package com.example.products_app.data.remote

import com.example.products_app.data.model.Product
import com.example.products_app.servicelocator.DEPENDANCY
import com.example.products_app.servicelocator.ServiceLocator

class ProductsRemoteDataSourceImpl(
    private val serviceLocator: ServiceLocator
) : RemoteDataSource {

    override suspend fun getAllProducts(): List<Product>? {
        val service = serviceLocator.getDependency<ProductService>(DEPENDANCY.PRODUCT_SERVICE)
        return try {
            service.getAllProducts().body()?.products
        } catch (th: Throwable) {
            throw th
        }
    }
}