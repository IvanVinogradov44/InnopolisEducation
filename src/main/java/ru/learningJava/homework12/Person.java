package ru.learningJava.homework12;

import java.io.*;
import java.time.LocalDate;

public class Person {
    private String secondName;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private Sex sex;
    private int age;

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
        String outPutFile = "src/main/java/ru/learningJava/homework12/persons/" + this.secondName + ".txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPutFile, true))) {
            File personFile = new File(outPutFile);
            if (!personFile.exists()) {
                System.out.println("Файл с такой фамилией не существует, создаем");
            }

            String personinfo = ("" + secondName + " " + firstName + " " + lastName + " " + dateOfBirth + " " + phoneNumber + " " + sex + age + "\n");
            bufferedWriter.write(personinfo);
        } catch (IOException e) {
            throw e;
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
