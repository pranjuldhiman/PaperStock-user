package com.macamp.paperstock.data.api

import com.macamp.paperstock.data.LoginRequest
import com.macamp.paperstock.data.model.LoginResponse
import com.macamp.paperstock.data.model.StocksModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {


    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("/stocks/get-live-stocks")
    suspend fun getStocksLiveData(): Response<StocksModel>


}