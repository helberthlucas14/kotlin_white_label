package com.example.kotlin_white_label.domain.type

sealed class ResultType<T> {
    data class Success<T>(val data: T) : ResultType<T>()
    data class Error<T>(val error: ErrorType) : ResultType<T>()
}
