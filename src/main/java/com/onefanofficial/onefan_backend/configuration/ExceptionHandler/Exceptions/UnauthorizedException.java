package com.onefanofficial.onefan_backend.configuration.ExceptionHandler.Exceptions;


public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }

}
