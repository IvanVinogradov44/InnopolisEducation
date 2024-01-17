package ru.learningJava.certification1.repositories;

import ru.learningJava.certification1.model.User;

import java.util.List;

public interface UserRepository {

    /**
     * создание пользователя и запись его в файл
     * @param user
     */
    void create (User user);

    /**
     * поиск пользователя в файле по идентификатору
     * @param id
     * @return
     */
    User findById (String id);

    /**
     * выгрузка всех пользователей из файла
     * @return
     */
    List<User> findAll();

    /**
     * обновление полей существующего в файле пользователя
     * @param user
     */
    void update(User user);

    /**
     * удаление пользователя по идентификатору
     * @param id
     */
    void deleteById(String id);

    /**
     * удаление всех пользователей
     */
    void deleteAll();
}
