package com.macamp.paperstock.ui.fragments.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.macamp.paperstock.data.api.ApiService.Companion.apiService
import com.macamp.paperstock.data.api.Resource
import com.macamp.paperstock.data.api.RetrofitClient.apiMainService
import kotlinx.coroutines.Dispatchers

class DashboardViewModel : ViewModel() {

//    val api = RetrofitClient2.apiClient()?.create(ApiService::class.java)
    fun getLiveStocks() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(apiMainService.getStocksLiveData()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = "Error Occurred!"))

        }
    }
}

