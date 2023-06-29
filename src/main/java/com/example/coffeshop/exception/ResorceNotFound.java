package com.example.coffeshop.exception;

public class ResorceNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ResorceNotFound(String message) {
        super(message);
    }
}
