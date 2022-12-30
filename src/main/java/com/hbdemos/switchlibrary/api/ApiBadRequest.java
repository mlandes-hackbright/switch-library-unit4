package com.hbdemos.switchlibrary.api;

import org.springframework.http.HttpStatus;

public class ApiBadRequest extends Exception {
    private HttpStatus status;

    public HttpStatus getStatus() { return this.status; }

    public ApiBadRequest(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ApiBadRequest(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }
}
