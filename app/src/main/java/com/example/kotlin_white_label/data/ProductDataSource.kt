package com.example.kotlin_white_label.data

import android.net.Uri
import com.example.kotlin_white_label.domain.model.Product

interface ProductDataSource {

    suspend fun getProducts(): List<Product>

    suspend fun uploadProductImage(imageUri: Uri): String

    suspend fun createProduct(product: Product): Product
}