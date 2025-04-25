package com.onefanofficial.onefan_backend.configuration.ExceptionHandler.Exceptions;


public class ResourceAlreadyExists extends RuntimeException {

    public ResourceAlreadyExists(String message) {
        super(message);
    }
}

