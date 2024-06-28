package com.example.pruebatecnica.home.presentation

import com.example.pruebatecnica.home.data.remote.response.Productos

interface ProductsEvents {
    fun moveToProductDetail(productDetail:Productos)
}