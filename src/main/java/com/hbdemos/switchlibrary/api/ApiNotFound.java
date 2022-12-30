package com.hbdemos.switchlibrary.api;

import org.springframework.http.HttpStatus;

public class ApiNotFound extends ApiBadRequest {
    public ApiNotFound(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public ApiNotFound(Long id) {
        this("item with id: " + id + " was not found");
    }
}
