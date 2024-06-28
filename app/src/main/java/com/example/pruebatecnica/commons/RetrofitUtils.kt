package com.example.pruebatecnica.commons

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun <T> getRetrofitBuilder(
    endPoint: Class<T>,
    httpClient: OkHttpClient.Builder,
    baseUrl: String = "http://alb-dev-ekt-875108740.us-east-1.elb.amazonaws.com/"
): T =
    Retrofit.Builder().baseUrl(baseUrl)
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(endPoint)

fun getApiClient(): OkHttpClient.Builder =
    OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)