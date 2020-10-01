package com.rls.ids.exceptions;

public class MissingRequiredFieldException extends BadRequestException {
    private static final long serialVersionUID = 1L;

    public MissingRequiredFieldException(String message) {
        super(message);
    }
}
