package com.example.kotlin_white_label.domain.usecase

import android.net.Uri
import com.example.kotlin_white_label.data.ProductRepository
import com.example.kotlin_white_label.domain.model.Product
import java.util.*
import javax.inject.Inject

class CreateProductUseCaseImpl @Inject constructor(
    private val uploadProductImageUseCase: UploadProductImageUseCase,
    private val productRepository: ProductRepository
) : CreateProductUseCase {

    override suspend fun invoke(description: String, price: Double, imageUri: Uri): Product {
        return try {
            val imageUrl = uploadProductImageUseCase(imageUri)
            val product = Product(UUID.randomUUID().toString(), description, price, imageUrl)
            productRepository.createProduct(product)
        } catch (e: Exception) {
            throw e
        }
    }
}