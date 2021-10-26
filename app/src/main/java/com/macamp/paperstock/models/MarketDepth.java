package com.macamp.paperstock.models;

import com.google.gson.annotations.SerializedName;
import com.macamp.paperstock.models.Depth;

import java.util.List;

/**
 * A wrapper for market depth data.
 */
public class MarketDepth {
    @SerializedName("buy")
    public List<com.macamp.paperstock.models.Depth> buy;
    @SerializedName("sell")
    public List<Depth> sell;
}
