package com.macamp.paperstock.models;

import com.google.gson.annotations.SerializedName;
import com.macamp.paperstock.models.MarginCalculationData;

import java.util.List;

/**
 * A wrapper for basket margin calculation response data.
 */

public class CombinedMarginData {
    @SerializedName("initial")
    public MarginCalculationData initialMargin;

    @SerializedName("final")
    public MarginCalculationData finalMargin;

    @SerializedName("orders")
    public List<MarginCalculationData> orders;
}