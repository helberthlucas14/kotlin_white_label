package com.example.kotlin_white_label.domain.usecase

import android.net.Uri
import com.example.kotlin_white_label.data.ProductRepository
import javax.inject.Inject

class UploadProductImageUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : UploadProductImageUseCase {

    override suspend fun invoke(imageUri: Uri): String =
        productRepository.uploadProductImage(imageUri)
}