package com.example.products_app.all

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllProductsScreen()
        }
    }
}
