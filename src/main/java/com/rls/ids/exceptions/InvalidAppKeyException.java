package com.rls.ids.exceptions;

public class InvalidAppKeyException extends BadRequestException {
    private static final long serialVersionUID = 1L;

    public InvalidAppKeyException(String message) {
        super(message);
    }
}
