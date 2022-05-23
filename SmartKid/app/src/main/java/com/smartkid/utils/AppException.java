package com.smartkid.utils;

public class AppException extends Exception{
    private int key;

    public AppException(String message, int key){
        super(message);
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
