package com.macamp.paperstock.ui.fragments.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.macamp.paperstock.data.LoginRequest
import com.macamp.paperstock.data.api.Resource
import com.macamp.paperstock.data.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class LoginViewModel : ViewModel() {
    private val api = RetrofitClient.apiService

    fun login(login: LoginRequest) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try{
            emit(Resource.success(api.login(login)))
        }catch (e:Exception){
            emit((Resource.error(data = null,message = api.login(login).message())))
        }

    }
}