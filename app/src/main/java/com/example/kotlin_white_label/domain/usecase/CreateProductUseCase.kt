package com.example.kotlin_white_label.domain.usecase

import android.net.Uri
import com.example.kotlin_white_label.domain.model.Product

interface CreateProductUseCase {
    suspend operator fun invoke(description: String, price: Double, imageUri: Uri): Product
}