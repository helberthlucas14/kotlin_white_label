package com.example.kotlin_white_label.domain

import com.example.kotlin_white_label.domain.type.ErrorType

interface ErrorHandler {

    fun getError(throwable: Throwable): ErrorType
}