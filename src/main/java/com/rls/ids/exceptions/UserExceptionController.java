package com.rls.ids.exceptions;

import com.rls.ids.models.ErrorResponseModel;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class UserExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ UserNotFoundException.class })
    public final ResponseEntity<Object> handleException(NotFoundException exception, WebRequest request) {
        ErrorResponseModel errorResponse = new ErrorResponseModel(HttpStatus.NOT_FOUND, exception.getMessage(),
                exception.getMessage());
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        // return new RsponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ MissingRequiredFieldException.class, JSONProcessingException.class,
            InvalidPayloadException.class, UnsupportedPayloadTypeException.class, UnsupportedSearchParameter.class,
            InvalidAppKeyException.class, MissingHeaderException.class, AlreadyExistsException.class })
    public final ResponseEntity<Object> handleException(BadRequestException exception, WebRequest request) {
        ErrorResponseModel errorResponse = new ErrorResponseModel(HttpStatus.BAD_REQUEST, exception.getMessage(),
                exception.getMessage());
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        // return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleDefault(Exception exception, WebRequest request) {
        ErrorResponseModel errorResponse = new ErrorResponseModel(HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(), exception.getMessage());
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
                request);
        // return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
