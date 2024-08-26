package com.ve.community.constants;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ResponseWrapper<T> {
    private static final long serialVersionUID = 1L;
    private HttpStatus statusCode;
    private String message;
    private T data;

    public ResponseWrapper(HttpStatus statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}