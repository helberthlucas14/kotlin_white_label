package com.example.kotlin_white_label.ui.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_white_label.R
import com.example.kotlin_white_label.config.Config
import com.example.kotlin_white_label.domain.model.Product
import com.example.kotlin_white_label.domain.type.ErrorType
import com.example.kotlin_white_label.domain.type.ResultType
import com.example.kotlin_white_label.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val config: Config
) : ViewModel() {

    private val _viewStateData = MutableLiveData<ViewState>()
    val viewStateData: LiveData<ViewState> = _viewStateData

    private val _addButtonVisibilityData = MutableLiveData(config.addButtonVisibility)
    val addButtonVisibilityData: LiveData<Int> = _addButtonVisibilityData

    fun getProducts() = viewModelScope.launch {
        _viewStateData.value = when (val result = getProductsUseCase()) {
            is ResultType.Success -> ViewState.ShowProducts(result.data)
            is ResultType.Error -> {
                ViewState.ShowError(
                    when (result.error) {
                        is ErrorType.AccessDenied -> R.string.products_error_access_denied
                        else -> R.string.products_error_unknown
                    }
                )
            }
        }
    }

    sealed class ViewState {
        class ShowProducts(val products: List<Product>) : ViewState()
        class ShowError(val messageResId: Int) : ViewState()
    }
}