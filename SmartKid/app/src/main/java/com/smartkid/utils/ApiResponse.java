package com.smartkid.utils;

public class ApiResponse<T> {
    String status;
    String message;
    String error;
    T data;

    public ApiResponse(String status, String message, String error, T data) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public ApiResponse(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
