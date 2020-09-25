package com.nsahoo.exception;

public class OrderNotFoundException extends Exception {
    String message;


    public OrderNotFoundException(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
