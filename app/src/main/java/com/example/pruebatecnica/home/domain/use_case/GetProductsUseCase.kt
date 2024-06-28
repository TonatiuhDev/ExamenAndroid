package com.example.pruebatecnica.home.domain.use_case

import com.example.pruebatecnica.commons.Resource
import com.example.pruebatecnica.home.data.api.ProductsApi
import com.example.pruebatecnica.home.data.remote.response.GetProductsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val api: ProductsApi) {
    operator fun invoke():
            Flow<Resource<out GetProductsResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getProducts()
            if (response.mensaje == "Operación Exitosa.")
                emit(Resource.Success(response))
            else
                emit(Resource.Error(response.mensaje))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
    }
}