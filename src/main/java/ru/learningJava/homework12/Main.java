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
                Person person = Person.getPerson(inputLine);
                person.putInfoToFiles();
                System.out.println(person);
            } catch (ValidationException | IOException exception) {
                System.out.println(exception.getMessage());
                continue;
            }

        }

    }


}
