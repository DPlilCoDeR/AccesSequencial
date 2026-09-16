package com.m486.persistencia;

public class GestioPersonaException extends RuntimeException {
    public GestioPersonaException(String message) {
        super(message);
    }

    public GestioPersonaException(String message, Throwable cause) {
        super(message, cause);
    }
}
