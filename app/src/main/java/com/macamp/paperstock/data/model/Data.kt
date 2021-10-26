package com.macamp.paperstock.data.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ATP")
    val aTP: String,
    @SerializedName("ask")
    val ask: String,
    @SerializedName("askQuantity")
    val askQuantity: String,
    @SerializedName("bid")
    val bid: String,
    @SerializedName("bidQuantity")
    val bidQuantity: String,
    @SerializedName("High")
    val high: String,
    @SerializedName("LTP")
    val lTP: String,
    @SerializedName("LastUpdateTime")
    val lastUpdateTime: String,
    @SerializedName("Low")
    val low: String,
    @SerializedName("Open")
    val `open`: String,
    @SerializedName("previousClose")
    val previousClose: String,
    @SerializedName("PreviousOpen")
    val previousOpen: String,
    @SerializedName("symbolId")
    val symbolId: String,
    @SerializedName("symbolName")
    val symbolName: String,
    @SerializedName("TickVolume")
    val tickVolume: String,
    @SerializedName("todaysOl")
    val todaysOl: String,
    @SerializedName("TotalVolume")
    val totalVolume: String,
    @SerializedName("turnOver")
    val turnOver: String
)