package com.macamp.paperstock.data

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("Username")
    val userName: String,
    @SerializedName("password")
    val password: String
)
