package com.macamp.paperstock.kiteconnect.kitehttp.exceptions;

import com.macamp.paperstock.kiteconnect.kitehttp.exceptions.KiteException;

/**
 * Represents all order placement and manipulation errors.
 * Default code is 500.
 */

public class OrderException extends KiteException {

    // initialize Order Exception and call base exception constructor
    public OrderException(String message, int code){
        super(message, code);
    }
}
