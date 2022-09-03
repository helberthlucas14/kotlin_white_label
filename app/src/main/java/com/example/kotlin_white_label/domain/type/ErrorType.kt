package com.example.kotlin_white_label.domain.type

sealed class ErrorType {
    object AccessDenied : ErrorType()
    object Unknown : ErrorType()
}
