package com.macamp.paperstock.models;

import com.google.gson.annotations.SerializedName;
import com.macamp.paperstock.models.OHLC;

/**
 * A wrapper for open, high, low, close, instrument token and last price
 */
public class OHLCQuote {

    @SerializedName("instrument_token")
    public long instrumentToken;
    @SerializedName("last_price")
    public double lastPrice;
    @SerializedName("ohlc")
    public OHLC ohlc;

}
