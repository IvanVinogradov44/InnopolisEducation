package ru.learningJava.certification1;

import com.github.javafaker.Faker;
import ru.learningJava.certification1.model.User;
import ru.learningJava.certification1.repositories.UserRepositoryFileImpl;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        UserRepositoryFileImpl userRepositoryFile = new UserRepositoryFileImpl();
        User newUser = new User("12","789ghs","789ghs","Иванов","Иван","Иванович",30,true);
        userRepositoryFile.create(newUser);
        System.out.println(newUser);
    }
}
