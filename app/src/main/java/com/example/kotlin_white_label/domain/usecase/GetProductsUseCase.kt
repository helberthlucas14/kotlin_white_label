package com.example.kotlin_white_label.domain.usecase

import android.net.Uri
import com.example.kotlin_white_label.domain.model.Product
import com.example.kotlin_white_label.domain.type.ResultType

interface GetProductsUseCase {
    suspend operator fun invoke(): ResultType<List<Product>>
}