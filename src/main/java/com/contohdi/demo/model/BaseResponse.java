package com.contohdi.demo.model;

public class BaseResponse<T> {
    private final Integer status;
    private final String message;
    private final T data;

    public BaseResponse(Integer status,String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
