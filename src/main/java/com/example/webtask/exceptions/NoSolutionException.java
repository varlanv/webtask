package com.example.webtask.exceptions;

public class NoSolutionException extends RuntimeException {

    public NoSolutionException() {
    }

    public NoSolutionException(String message) {
        super(message);
    }

    public NoSolutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
