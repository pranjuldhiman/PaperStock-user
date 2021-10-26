package com.macamp.paperstock.ui.fragments.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.macamp.paperstock.data.LoginRequest
import com.macamp.paperstock.data.api.Resource
import com.macamp.paperstock.data.api.RetrofitClient
import com.macamp.paperstock.data.model.StocksModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class DashboardViewModel : ViewModel() {

    val api = RetrofitClient.apiMainService

    fun getLiveStocks() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(api.getStocksLiveData()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = "Error Occurred!"))

        }

    }
}

