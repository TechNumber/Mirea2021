package com.mirea.demo.exception;

import java.text.MessageFormat;

public class RequestNotFoundException extends RuntimeException {
    public RequestNotFoundException(Long id) {
        super(MessageFormat.format("Request with id = {0} not found!", id));
    }
}
