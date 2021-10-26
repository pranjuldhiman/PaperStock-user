package com.macamp.paperstock.ticker;

import com.macamp.paperstock.models.Order;

/**
 * Created by sujith on 12/26/17.
 */
public interface OnOrderUpdate {
    void onOrderUpdate(Order order);
}
