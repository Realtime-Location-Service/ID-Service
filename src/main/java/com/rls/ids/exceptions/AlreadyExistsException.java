package com.rls.ids.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AlreadyExistsException extends BadRequestException {
    private static final long serialVersionUID = 1L;

    public AlreadyExistsException(String message) {
        super(message);
    }
}