package ru.learningJava.certification1.exceptions;

public class ValidationException extends IllegalArgumentException{
    public ValidationException(String message) {
        super(message);
    }
}
