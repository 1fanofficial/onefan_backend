package com.onefanofficial.onefan_backend.configuration.ExceptionHandler.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
