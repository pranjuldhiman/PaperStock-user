package com.macamp.paperstock.data.model


import com.google.gson.annotations.SerializedName

data class StocksModel(
    @SerializedName("data")
    val stockData: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)