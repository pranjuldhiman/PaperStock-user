package com.macamp.paperstock.data.api

import com.google.gson.GsonBuilder
import com.macamp.paperstock.data.LoginRequest
import com.macamp.paperstock.data.model.LoginResponse
import com.macamp.paperstock.data.model.StocksModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("v1/stocks/get-live-stocks")
    suspend fun getStocksLiveData(): Response<StocksModel>

    companion object {
        private const val productionURL = "http://34.226.121.217/api/"
        val apiService: ApiService by lazy {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(productionURL)
                .client(RetrofitClient.okHttpClient)
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .setLenient()
                            .create()
                    )
                )
                .build().create(ApiService::class.java)
        }
    }

}


//object RetrofitClient2 {
//    private const val productionURL = "http://34.226.121.217/api/"
//    private var mRetrofit: Retrofit? = null
//
//    fun apiClient(): Retrofit? {
//        if (mRetrofit == null) {
//            val interceptor = HttpLoggingInterceptor()
//            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(50, TimeUnit.SECONDS)
//                .writeTimeout(50, TimeUnit.SECONDS)
//                .addNetworkInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
//                .build()
//            mRetrofit = Retrofit.Builder()
//                .baseUrl(productionURL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build()
//        }
//        return mRetrofit
//    }
//
//
//    //Creating service class for calling the api services
//    fun createService(): ApiService? {
//        return mRetrofit?.create(ApiService::class.java)
//    }
//
//
//}