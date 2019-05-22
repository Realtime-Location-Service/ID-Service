package com.rls.ids.exceptions;

public class JSONProcessingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public JSONProcessingException(String message) {
        super(message);
    }
}
