package ru.learningJava.certification1.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.learningJava.certification1.model.User;

import java.util.NoSuchElementException;
import java.util.Random;



class UserRepositoryFileImplTest {
    UserRepositoryFileImpl userRepositoryFileImpl = new UserRepositoryFileImpl();
    Random random = new Random();
    User testUser;

    @BeforeEach
    void setUp(){
        testUser = new User("testUser","qwe123", "qwe123","Тест", "Тест", "Тест", random.nextInt(20,40), random.nextBoolean());
    }

    @Test
    @DisplayName("Проверка создания пользователя")
    void create() {
        userRepositoryFileImpl.create(testUser);
        Assertions.assertNotNull(userRepositoryFileImpl.findById(testUser.getId()));
    }

    @Test
    @DisplayName("Проверка поиска по ID")
    void findById() {
        userRepositoryFileImpl.create(testUser);
        Assertions.assertNotNull(userRepositoryFileImpl.findById(testUser.getId()));
    }

    @Test
    @DisplayName("Проверка поиска по ID отсутствующего пользователя")
    void findById_negative() {
        Assertions.assertThrows(NoSuchElementException.class, ()-> userRepositoryFileImpl.findById(testUser.getId()));
    }

    @Test
    @DisplayName("Проверка поиска по логину")
    void findByLogin() {
        userRepositoryFileImpl.create(testUser);
        Assertions.assertNotNull(userRepositoryFileImpl.findByLogin(testUser.getLogin()));
    }

    @Test
    @DisplayName("Проверка поиска по логину несуществующего пользователя")
    void findByLogin_negative() {
        Assertions.assertThrows(NoSuchElementException.class, ()-> userRepositoryFileImpl.findByLogin(testUser.getLogin()));
    }

    @Test
    @DisplayName("Проверка вывода всех пользователей")
    void findAll() {
        userRepositoryFileImpl.create(testUser);
        User secondTestUser = new User("secondUser","qwe123", "qwe123","Тест", "Тест", "Тест", random.nextInt(20,40), random.nextBoolean());
        userRepositoryFileImpl.create(secondTestUser);
        Assertions.assertTrue(userRepositoryFileImpl.findAll().size()>1);
    }

    @Test
    @DisplayName("Проверка обновления пользователя")
    void update() {
        userRepositoryFileImpl.create(testUser);
        String newLogin = "updatedTestUser";
        testUser.setLogin(newLogin);
        userRepositoryFileImpl.findAll();
        userRepositoryFileImpl.update(testUser);
        Assertions.assertEquals(userRepositoryFileImpl.findById(testUser.getId()).getLogin(),newLogin);
        System.out.println();
    }

    @Test
    @DisplayName("Проверка обновления несуществующего пользователя")
    void update_negative() {
        Assertions.assertThrows(NoSuchElementException.class, ()-> userRepositoryFileImpl.update(testUser));
    }

    @Test
    @DisplayName("Проверка удаления пользователя по ID")
    void deleteById() {
        userRepositoryFileImpl.create(testUser);
        userRepositoryFileImpl.deleteById(testUser.getId());
        Assertions.assertThrows(NoSuchElementException.class,()-> userRepositoryFileImpl.findById(testUser.getId()));
    }

    @Test
    @DisplayName("Проверка удаления несуществующего пользователя по ID")
    void deleteById_negative() {
        Assertions.assertThrows(NoSuchElementException.class,()-> userRepositoryFileImpl.deleteById(testUser.getId()));
    }

    @Test
    @DisplayName("Проверка удаления всех пользователей")
    void deleteAll() {
        User testUser = new User("testUser","qwe123", "qwe123","Тест", "Тест", "Тест", random.nextInt(20,40), random.nextBoolean());
        userRepositoryFileImpl.create(testUser);
        userRepositoryFileImpl.deleteAll();
        Assertions.assertTrue(userRepositoryFileImpl.userList.isEmpty());
    }
}