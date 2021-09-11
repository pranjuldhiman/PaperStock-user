package com.macamp.paperstock.data.model


data class NSEData(
    val success: Boolean,
    val message: String,
    val symbolsadded: Int,
    val symbollist: List<List<String>>,
    val totalsymbolsubscribed: Int
)