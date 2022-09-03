package com.example.kotlin_white_label.data.di

import com.example.kotlin_white_label.data.GeneralErrorHandlerImpl
import com.example.kotlin_white_label.domain.ErrorHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ErrorHandleModule {

    @Singleton
    @Binds
    fun bindErrorHandler(errorHandler: GeneralErrorHandlerImpl): ErrorHandler
}