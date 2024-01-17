package ru.learningJava.certification1.model;

import ru.learningJava.certification1.exceptions.ValidationException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String id;
    private LocalDate date;
    private String login;
    private String password;
    private String confirmPassword;
    private String secondName;
    private String firstName;
    private String lastName;
    private int age;
    private boolean isWorker;

    public User() {
    }

    public User(String login,
                String password,
                String confirmPassword,
                String secondName,
                String firstName,
                String lastName,
                int age,
                boolean isWorker) {
        this.id = UUID.randomUUID().toString();
        this.date = LocalDate.now();

        try {
            if (login.matches("^([0-9]{0,20})$")) {
                throw new ValidationException("Логин не может состоять только из цифр");
            } else if (login.matches("^([A-Za-z0-9_]{0,20})$")) {
                this.login = login;
            } else {
                throw new ValidationException("Неверный формат логина");
            }

            if (password.matches("^([A-Za-z]{0,20})$")) {
                throw new ValidationException("Пароль не может состоять только из букв");
            } else if (password.matches("^([A-Za-z0-9_]{0,20})$")){
                this.password = password;
            } else {
                throw new ValidationException("Неверный формат пароля");
            }

            if (password == confirmPassword){
                this.confirmPassword = confirmPassword;
            }
            else {
                throw new ValidationException("Пароли не совпадают");
            }

            if (secondName.matches("^([А-Яа-я]{1,256})$")){
                this.secondName = secondName;
            }
            else {
                throw new ValidationException("Неверный формат фамилии" + secondName);
            }

            if (firstName.matches("^([А-Яа-я]{1,256})$")){
                this.firstName = firstName;
            }
            else {
                throw new ValidationException("Неверный формат имени");
            }

            if (lastName.matches("^([А-Яа-я]{1,256})$")){
                this.lastName = lastName;
            }
            else {
                throw new ValidationException("Неверный формат отчества");
            }

        } catch (ValidationException e){
            throw new ValidationException(e.getMessage());
        }


        this.age = age;
        this.isWorker = isWorker;
    }


    public User(String id, LocalDate date, String login, String password, String confirmPassword, String secondName, String firstName, String lastName, int age, boolean isWorker) {
        this.id = id;
        this.date = date;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.secondName = secondName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isWorker = isWorker;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNewId(String id) {
        this.id = UUID.randomUUID().toString();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public String toString() {
        return id + "," +
                date + "," +
                login + "," +
                password + "," +
                confirmPassword + "," +
                secondName + "," +
                firstName + "," +
                lastName + "," +
                age + "," +
                isWorker + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && isWorker == user.isWorker && Objects.equals(id, user.id) && Objects.equals(date, user.date) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(secondName, user.secondName) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, login, password, confirmPassword, secondName, firstName, lastName, age, isWorker);
    }
}
