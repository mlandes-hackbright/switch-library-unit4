package com.hbdemos.switchlibrary.api;

import com.hbdemos.switchlibrary.dto.ApiErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlers {
    @ExceptionHandler
    public ResponseEntity<?> handleClientError(ApiBadRequest error) {
        var content = new ApiErrorDTO(error.getMessage());
        return ResponseEntity
                .status(error.getStatus())
                .body(content);
    }
}
