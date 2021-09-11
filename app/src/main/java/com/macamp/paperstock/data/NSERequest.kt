package com.macamp.paperstock.data

import com.google.gson.annotations.SerializedName

data class NSERequest(   @SerializedName("method") var method : String?=null,
                         @SerializedName("symbols") var symbols : List<String>?= emptyList())
data class BitcoinRequest (

    @SerializedName("type") var type : String?,
    @SerializedName("product_ids") var productIds : List<String>?= emptyList(),
    @SerializedName("channels") var channels : List<String>?= emptyList()

)