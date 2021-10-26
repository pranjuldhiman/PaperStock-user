package com.macamp.paperstock.ticker;

import com.macamp.paperstock.kiteconnect.kitehttp.exceptions.KiteException;

/**
 * Created by sujith on 11/21/17.
 */
public interface OnError {

    public void onError(Exception exception);

    public void onError(KiteException kiteException);

    void onError(String error);
}
