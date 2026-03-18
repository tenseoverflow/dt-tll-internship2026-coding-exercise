package com.dynatrace.pong.exception;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String email) {
        super("A player with email '" + email + "' already exists");
    }
}

