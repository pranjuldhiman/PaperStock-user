package com.macamp.paperstock.data.api

import com.google.gson.GsonBuilder
import com.macamp.paperstock.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val baseURL = "https://traderappp.herokuapp.com/${Constants.APP_TYPE}/"
    private const val productionURL = "http://34.226.121.217/api/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseURL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .build().create(ApiService::class.java)
    }

    val apiMainService: ApiService by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(productionURL)
            .addConverterFactory(
                GsonConverterFactory.create(
                   /* GsonBuilder()
                        .setLenient()
                        .create()*/
                )
            )
            .build().create(ApiService::class.java)
    }


}