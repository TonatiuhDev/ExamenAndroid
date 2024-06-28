package com.example.pruebatecnica.home.domain.model

import com.example.pruebatecnica.home.data.remote.response.GetProductsResponse

data class GetProductsState(
    val isLoading: Boolean = false,
    val getProductsResponse: GetProductsResponse? = null,
    val error: String? = null
)