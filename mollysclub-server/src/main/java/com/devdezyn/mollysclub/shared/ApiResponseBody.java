package com.devdezyn.mollysclub.shared;

import lombok.Data;

@Data
public class ApiResponseBody<T> {
    private Boolean status;
    private String message;
    private T data;

    public ApiResponseBody(Boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponseBody(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
