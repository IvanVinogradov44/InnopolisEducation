package ru.learningJava.certification1.repositories;

import ru.learningJava.certification1.model.User;
import ru.learningJava.certification1.utils.FileReaderWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserRepositoryFileImpl implements UserRepository {

    List<User> userList = findAll();

    @Override
    public void create(User user) {
        userList.add(user);
        FileReaderWriter.writeUsersToFile(userList);
    }

    @Override
    public User findById(String id) {
        try {
            User foundUser = userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
            return foundUser;
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("пользователь не найден");
        }
    }

    public User findByLogin(String login) {
        try {
            User foundUser = userList.stream().filter(user -> user.getLogin().equals(login)).findFirst().get();
            return foundUser;
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("пользователь не найден");
        }
    }

    @Override
    public List<User> findAll() {

        return userList = FileReaderWriter.getUsers();
    }

    @Override
    public void update(User updatedUser) {
        try {
            User userForUpdate = userList.stream().filter(user -> user.getId().equals(updatedUser.getId())).findFirst().get();
            userList.set(userList.indexOf(userForUpdate), updatedUser);
            FileReaderWriter.writeUsersToFile(userList);
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("пользователь не найден");
        }
    }

    @Override
    public void deleteById(String idForDelete) {
        try {
            User userToDelete = userList.stream().filter(user -> user.getId().equals(idForDelete)).findFirst().get();
            userList.remove(userToDelete);
            FileReaderWriter.writeUsersToFile(userList);
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("пользователь не найден");
        }
    }

    @Override
    public void deleteAll() {
        userList.clear();
        FileReaderWriter.deleteAll();
    }
}
