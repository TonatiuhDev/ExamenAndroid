package com.example.pruebatecnica.di

import com.example.pruebatecnica.commons.getApiClient
import com.example.pruebatecnica.commons.getRetrofitBuilder
import com.example.pruebatecnica.home.data.api.ProductsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun providesUsersApi(): ProductsApi =
        getRetrofitBuilder(ProductsApi::class.java, getApiClient())

}