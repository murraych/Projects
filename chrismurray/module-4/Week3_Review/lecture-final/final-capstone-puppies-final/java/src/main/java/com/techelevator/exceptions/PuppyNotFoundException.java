package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PuppyNotFoundException extends RuntimeException {

    /**
    *
    */
    private static final long serialVersionUID = -1218496597492879379L;

    public PuppyNotFoundException() {
    }

    public PuppyNotFoundException(String message) {
        super(message);
    }

    public PuppyNotFoundException(Throwable cause) {
        super(cause);
    }

    public PuppyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PuppyNotFoundException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
