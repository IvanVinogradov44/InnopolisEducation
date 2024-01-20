package ru.learningJava.homework12;

import ru.learningJava.homework12.utils.FileWriter;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String secondName;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private Sex sex;
    private int age;

    public Person() {
    }

    public Person(String secondName, String firstName, String lastName, LocalDate dateOfBirth, long phoneNumber, Sex sex, int age) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.age = age;
    }

    public void putInfoToFiles() throws IOException {

        String personinfo = (secondName + " " + firstName + " " + lastName + " " + dateOfBirth + " " + phoneNumber + " " + sex + age + "\n");
        FileWriter.putInfoToFiles(personinfo, secondName);
    }


    public static Person getPerson(String inputLine) {

        String[] params = inputLine.split(",");

        List<String> exceptionsList = new ArrayList<>();

        if (params.length > 7) {
            throw new ValidationException("Введено слишком много параметров");
        } else if (params.length < 7) {
            throw new ValidationException("Введено слишком мало параметров");
        }
        String secondName = params[0];
        String firstName = params[1];
        String lastName = params[2];
        String dateOfBirth = params[3];
        String phoneNumber = params[4];
        String sex = params[5];
        String age = params[6];

        String regex = "[А-Я]{1}+[а-я]*$";

        if (!secondName.matches(regex)) {
//            throw new ValidationException("Неверный формат фамилии");
            exceptionsList.add("Фамилия");
        }

        if (!firstName.matches(regex)) {
//            throw new ValidationException("Неверный формат имени");
            exceptionsList.add("Имя");
        }

        if (!lastName.matches(regex)) {
//            throw new ValidationException("Неверный формат Отчества");
            exceptionsList.add("Отчество");
        }

        LocalDate personDateOfBirth = getDate(dateOfBirth, exceptionsList);

        long personPhoneNumber = getPersonPhoneNumber(phoneNumber, exceptionsList);

        Sex personSex = getSex(sex, exceptionsList);

        int personAge = getPersonAge(age, exceptionsList);

        if (!exceptionsList.isEmpty()){
            throw new ValidationException(exceptionsList);
        }

        return new Person(secondName, firstName, lastName, personDateOfBirth, personPhoneNumber, personSex, personAge);
    }

    private static int getPersonAge(String age, List<String> exceptionsList) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException numberFormatException) {
            exceptionsList.add("Возраст");
            return 0;
        }
    }

    private static Sex getSex(String sex, List<String> exceptionsList) {
        try {
            return Sex.valueOf(sex);
        } catch (IllegalArgumentException illegalArgumentException) {
            exceptionsList.add("Пол");
            return null;
        }
    }

    private static long getPersonPhoneNumber(String phoneNumber, List<String> exceptionsList) {
        if (phoneNumber.matches("^((8)+[0-9]{10})$")) {
            return Long.parseLong(phoneNumber);
        } else {
            exceptionsList.add("Номер телефона");
            return 0;
        }
    }

    private static LocalDate getDate(String date, List<String> exceptionsList) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            return LocalDate.parse(date, dateFormat);
        } catch (DateTimeParseException exception) {
            exceptionsList.add("Дата");
            return null;
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber=" + phoneNumber +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
