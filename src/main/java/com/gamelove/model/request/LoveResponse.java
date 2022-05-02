package com.gamelove.model.request;

import java.io.Serializable;

/**
 * Created by sahan on 2022-04-26.
 */
public class LoveResponse implements Serializable{
   private final String message;

    public LoveResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
