//package com.ve.community.constants;

//import lombok.Data;
//import org.springframework.http.HttpStatus;
//@Data
//public class ResponseWrapper<T> {
    /*private static final long serialVersionUID = 1L;
     
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
    }*/
//}
package com.ve.community.constants;

import org.springframework.http.HttpStatus;

public class ResponseWrapper<T> {
    private int statusCode;
    private String message;
    private boolean success;
    private T data;

    // Constructors
    public ResponseWrapper() {
    }

    // Constructor for responses with data
    public ResponseWrapper(HttpStatus status, String message, boolean success, T data) {
        this.statusCode = status.value();
        this.message = message;
        this.success = success;
        this.data = data;
    }

    // Constructor for responses without data
    public ResponseWrapper(HttpStatus status, String message, boolean success) {
        this.statusCode = status.value();
        this.message = message;
        this.success = success;
    }

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
               "statusCode=" + statusCode +
               ", message='" + message + '\'' +
               ", success=" + success +
               ", data=" + data +
               '}';
    }
}
