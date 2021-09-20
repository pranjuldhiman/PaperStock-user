package com.macamp.paperstock.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status") var status: Boolean,
    @SerializedName("message") var message: String,
    @SerializedName("token") var token: Token
)

data class User(

    @SerializedName("_id") var Id: String,
    @SerializedName("Name") var Name: String,
    @SerializedName("Username") var Username: String,
    @SerializedName("password") var password: String,
    @SerializedName("MobileNumber") var MobileNumber: String,
    @SerializedName("broker") var broker: String,
    @SerializedName("__v") var _v: Int

)

data class Token(

    @SerializedName("token") var token: String,
    @SerializedName("user") var user: List<User>

)