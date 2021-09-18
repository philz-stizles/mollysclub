package com.devdezyn.mollysclub.shared.errors;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiError {

    private Boolean status;
    private String message;
    private List<String> errors;

    public ApiError(Boolean status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(Boolean status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
