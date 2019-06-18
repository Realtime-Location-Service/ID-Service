package com.rls.ids.exceptions;

public class MissingRequestParameterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MissingRequestParameterException(String message) {
        super(message);
    }
}
