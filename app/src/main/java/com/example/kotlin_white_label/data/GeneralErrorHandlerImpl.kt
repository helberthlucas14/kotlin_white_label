package com.example.kotlin_white_label.data

import android.accounts.NetworkErrorException
import android.net.NetworkRequest
import com.example.kotlin_white_label.domain.ErrorHandler
import com.example.kotlin_white_label.domain.type.ErrorType
import com.google.firebase.firestore.FirebaseFirestoreException
import java.net.UnknownHostException
import javax.inject.Inject

class GeneralErrorHandlerImpl @Inject constructor() : ErrorHandler {
    override fun getError(throwable: Throwable): ErrorType {
        return when (throwable) {
            is FirebaseFirestoreException -> {
                if (throwable.code == FirebaseFirestoreException.Code.PERMISSION_DENIED) {
                    ErrorType.AccessDenied
                } else ErrorType.Unknown
            }
            else -> ErrorType.Unknown
        }
    }
}