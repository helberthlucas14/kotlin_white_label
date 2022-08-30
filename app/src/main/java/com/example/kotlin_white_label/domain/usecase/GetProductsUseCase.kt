package com.example.kotlin_white_label.domain.usecase

import android.net.Uri
import com.example.kotlin_white_label.domain.model.Product

interface GetProductsUseCase {
    suspend operator fun invoke(): List<Product>
}