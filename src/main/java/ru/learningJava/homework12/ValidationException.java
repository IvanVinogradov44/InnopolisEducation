package ru.learningJava.homework12;

import java.util.List;

public class ValidationException extends RuntimeException{
    public ValidationException(List<String> message) {
        super(message.toString());
    }

    public ValidationException(String message) {
        super(message);
    }
}
