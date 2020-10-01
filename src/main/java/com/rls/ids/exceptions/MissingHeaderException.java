package com.rls.ids.exceptions;

public class MissingHeaderException extends BadRequestException {
    private static final long serialVersionUID = 1L;

    public MissingHeaderException(String message) {
        super(message);
    }
}
