package ru.learningJava.certification1.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.learningJava.certification1.exceptions.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User testUser;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Успешное создание пользователя")
    void User() {
        Assertions.assertDoesNotThrow( ()-> testUser = new User("12asd","789ghs","789ghs","Иванов","Иван","Иванович",30,true));
    }

    @Test
    @DisplayName("Создание пользователя c логином из цифр")
    void User_BadLogin_onliNumbers() {
        Assertions.assertThrows(ValidationException.class, ()-> testUser = new User("12","789ghs","789ghs","Иванов","Иван","Иванович",30,true));
    }

    @Test
    @DisplayName("Создание пользователя c невалидным логином")
    void User_BadLogin() {
        Assertions.assertThrows(ValidationException.class, ()-> testUser = new User("qweqweqweqweqweqweqwe","789ghs","789ghs","Иванов","Иван","Иванович",30,true));
    }

    @Test
    @DisplayName("Создание пользователя c паролем из букв")
    void User_BadPassword_onlyChars() {
        Assertions.assertThrows(ValidationException.class, ()-> testUser = new User("testLogin","ghs","789ghs","Иванов","Иван","Иванович",30,true));
    }

    @Test
    @DisplayName("Создание пользователя c невалидным паролем")
    void User_BadPassword_toManyChars() {
        Assertions.assertThrows(ValidationException.class, ()-> testUser = new User("testLogin","789ghsqweqweqweqweqweqweqwe","789ghs","Иванов","Иван","Иванович",30,true));
    }

    @Test
    @DisplayName("Создание пользователя c неверным подтверждением пароля")
    void User_wrongConfirmPassword() {
        Assertions.assertThrows(ValidationException.class, ()-> testUser = new User("testLogin","789ghs","789","Иванов","Иван","Иванович",30,true));
    }

    @Test
    @DisplayName("Создание пользователя c некорректной фамилией")
    void User_badSecondName() {
        Assertions.assertThrows(ValidationException.class, ()-> testUser = new User("testLogin","789ghs","789ghs","AAA","Иван","Иванович",30,true));
    }

    @Test
    @DisplayName("Создание пользователя c некорректной именем")
    void User_badFirstName() {
        Assertions.assertThrows(ValidationException.class, ()-> testUser = new User("testLogin","789ghs","789ghs","Иванов","AAA","Иванович",30,true));
    }

    @Test
    @DisplayName("Создание пользователя c некорректной отчеством")
    void User_badLastName() {
        Assertions.assertThrows(ValidationException.class, ()-> testUser = new User("testLogin","789ghs","789ghs","Иванов","Иван","AAA",30,true));
    }
}