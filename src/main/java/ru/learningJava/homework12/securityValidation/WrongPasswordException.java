package ru.learningJava.homework12.securityValidation;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
    }
}
