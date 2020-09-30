package com.rls.ids.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponseModel {
    private int status;
    private HttpStatus statusText;
    private String error;
    private String message;
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timestamp;
    private List<String> subErrors;
    private String path;

    public ErrorResponseModel(HttpStatus status, String message, List<String> subErrors, WebRequest request) {
        super();

        this.timestamp = new Date();
        this.status = status.value();
        this.statusText = status;
        this.error = status.getReasonPhrase();
        this.message = message;
        this.subErrors = subErrors;
        this.path = request.getDescription(false).substring(4);
    }

    public ErrorResponseModel(HttpStatus status, String message, String subError, WebRequest request) {
        super();

        this.timestamp = new Date();
        this.status = status.value();
        this.statusText = status;
        this.error = status.getReasonPhrase();
        this.message = message;
        this.subErrors = Arrays.asList(subError);
        this.path = request.getDescription(false).substring(4);
    }

    public HttpStatus getStatusText() {
        return statusText;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public String getError() {
        return error;
    }

    public List<String> getSubErrors() {
        return subErrors;
    }
}
