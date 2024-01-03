package ru.learningJava.homework6.utils;

public class Parser {

    private static int parseCount(String valueToParse){
        try {
            return Integer.parseInt(valueToParse);
        } catch (NumberFormatException exception){
            throw new ValidationException("Невалидное значение");
        }
    }

    public static int validateCount(String valueToValidate){
        try {
            return parseCount(valueToValidate);
        } catch (ValidationException validationException) {
            throw validationException;
        }
    }

    private static double parseNumber (String valueToParse){
        try{
            return Double.parseDouble(valueToParse);
        } catch (NumberFormatException numberFormatException){
            throw new ValidationException("Невалидное значение");
        }
    }

    public static double validateNumber (String valueToValidate){
        try {
            return parseNumber(valueToValidate);
        } catch (ValidationException validationException){
            throw validationException;
        }
    }
}
