package ru.learningJava.homework12;

import ru.learningJava.homework12.securityValidation.User;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {

        User.checkUserCreds("asd_3w", "123", "123");

        System.out.println("Введите данные в формате Фамилия, Имя, Отчество, дата рождения, номер телефона, пол (f, m), возраст");
        String status = "on";
        String[] params;
        String inputLine;
        Scanner lineScanner = new Scanner(System.in);

        while (status.equals("on")) {
            inputLine = lineScanner.nextLine();
            if (inputLine.equals("end")) {
                status = "off";
                break;
            }

            try {
                Person person = getPerson(inputLine);
                person.putInfoToFiles();
                System.out.println(person);
            } catch (ValidationException | IOException exception) {
                System.out.println(exception.getMessage());
                continue;
            }

        }

    }

    private static Person getPerson(String inputLine) {

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

        if (!secondName.matches("[А-Я]{1}+[а-я]*$")) {
//            throw new ValidationException("Неверный формат фамилии");
            exceptionsList.add("Фамилия");
        }

        if (!firstName.matches("[А-Я]{1}+[а-я]*$")) {
//            throw new ValidationException("Неверный формат имени");
            exceptionsList.add("Имя");
        }

        if (!lastName.matches("[А-Я]{1}+[а-я]*$")) {
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
}
