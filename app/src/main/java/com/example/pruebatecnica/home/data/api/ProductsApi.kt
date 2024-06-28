package com.example.pruebatecnica.home.data.api

import com.example.pruebatecnica.home.data.remote.response.GetProductsResponse
import retrofit2.http.GET

interface ProductsApi {
    @GET("apps/moviles/caso-practico/plp")
    suspend fun getProducts(): GetProductsResponse
}