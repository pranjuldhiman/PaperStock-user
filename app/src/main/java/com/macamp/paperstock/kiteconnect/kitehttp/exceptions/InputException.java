package com.macamp.paperstock.kiteconnect.kitehttp.exceptions;

import com.macamp.paperstock.kiteconnect.kitehttp.exceptions.KiteException;

/**
 * Represents user input errors such as missing and invalid parameters.
 * Default code is 400.
 */
public class InputException extends KiteException {
    // initialize and call base exception constructor
    public InputException(String message, int code){
        super(message, code);
    }
}

