package ru.learningJava.certification1.repositories;

import ru.learningJava.certification1.model.User;
import ru.learningJava.certification1.utils.FileReaderWriter;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryFileImpl implements UserRepository{

    List<User> userList = findAll();

    @Override
    public void create(User user) {
        userList.add(user);
        FileReaderWriter.writeUsersToFile(userList);
    }

    @Override
    public User findById(String id) {

        User foundUser = userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
        return foundUser;
    }

    @Override
    public List<User> findAll() {

        return userList = FileReaderWriter.getUsers();
    }

    @Override
    public void update(User updatedUser) {
        User userForUpdate = userList.stream().filter(user -> user.getId().equals(updatedUser.getId())).findFirst().get();
        userList.set(userList.indexOf(userForUpdate),updatedUser);
        FileReaderWriter.writeUsersToFile(userList);
    }

    @Override
    public void deleteById(String idForDelete) {
        User userToDelete = userList.stream().filter(user -> user.getId().equals(idForDelete)).findFirst().get();
        userList.remove(userToDelete);
        FileReaderWriter.writeUsersToFile(userList);
    }

    @Override
    public void deleteAll() {
        userList.clear();
        FileReaderWriter.deleteAll();
    }
}
