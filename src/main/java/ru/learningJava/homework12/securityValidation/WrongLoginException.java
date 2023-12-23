package ru.learningJava.homework12.securityValidation;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException() {
    }
}
