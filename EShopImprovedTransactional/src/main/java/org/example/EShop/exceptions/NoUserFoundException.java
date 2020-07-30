package org.example.EShop.exceptions;

public class NoUserFoundException extends Exception {
    public NoUserFoundException() {
    }

    public NoUserFoundException(String message) {
        super(message);
    }
}
