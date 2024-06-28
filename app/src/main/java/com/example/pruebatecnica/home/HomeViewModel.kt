package com.example.pruebatecnica.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.commons.Resource
import com.example.pruebatecnica.home.data.remote.response.Productos
import com.example.pruebatecnica.home.domain.model.GetProductsState
import com.example.pruebatecnica.home.domain.use_case.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _getProducts: MutableLiveData<GetProductsState> = MutableLiveData()

    val getProducts: MutableLiveData<GetProductsState> get() = _getProducts
    val myProduct: MutableLiveData<Productos> = MutableLiveData()

    fun getProducts() {
        getProductsUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _getProducts.postValue(GetProductsState(isLoading = true))
                }
                is Resource.Success -> {
                    _getProducts.postValue(
                        GetProductsState(isLoading = false, getProductsResponse = result.data)
                    )
                }
                is Resource.Error -> {
                    _getProducts.postValue(
                        GetProductsState(isLoading = false, error = result.message)
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}