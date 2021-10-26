package com.macamp.paperstock.ticker;

import com.macamp.paperstock.models.Tick;

import java.util.ArrayList;

/**
 * Callback to listen to com.macamp.paperstock.ticker websocket on tick arrival event.
 */

/** OnTicks interface is called once ticks arrive.*/
public interface OnTicks {
    void onTicks(ArrayList<Tick> ticks);
}
