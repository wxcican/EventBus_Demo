package com.fuicuiedu.idedemo.eventbus_demo;

/**
 * Created by Administrator on 2016/11/29 0029.
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
