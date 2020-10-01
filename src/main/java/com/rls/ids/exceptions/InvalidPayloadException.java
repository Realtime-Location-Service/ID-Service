package com.rls.ids.exceptions;

public class InvalidPayloadException extends BadRequestException {
    private static final long serialVersionUID = 1L;

    public InvalidPayloadException(String message) {
        super(message);
    }
}
