package com.maia.publication.exceptions;

public class NotFountException extends RuntimeException{
    public NotFountException(Throwable cause) {
        super("Not Found.",cause);
    }
}
