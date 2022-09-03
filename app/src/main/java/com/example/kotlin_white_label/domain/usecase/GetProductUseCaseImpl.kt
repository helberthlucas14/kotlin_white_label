package com.example.kotlin_white_label.domain.usecase

import com.example.kotlin_white_label.data.ProductRepository
import com.example.kotlin_white_label.domain.ErrorHandler
import com.example.kotlin_white_label.domain.model.Product
import com.example.kotlin_white_label.domain.type.ResultType
import javax.inject.Inject

class GetProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val errorHandler: ErrorHandler
) : GetProductsUseCase {

    override suspend fun invoke(): ResultType<List<Product>> {
        return try {
            val products = productRepository.getProducts()
            ResultType.Success(products)
        } catch (throwable: Throwable) {
            val error = errorHandler.getError(throwable)
            ResultType.Error(error)
        }
    }
}