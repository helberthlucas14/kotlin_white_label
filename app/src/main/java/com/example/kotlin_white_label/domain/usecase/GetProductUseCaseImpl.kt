package com.example.kotlin_white_label.domain.usecase

import com.example.kotlin_white_label.data.ProductRepository
import com.example.kotlin_white_label.domain.model.Product
import javax.inject.Inject

class GetProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductsUseCase {

    override suspend fun invoke(): List<Product> = productRepository.getProducts()
}