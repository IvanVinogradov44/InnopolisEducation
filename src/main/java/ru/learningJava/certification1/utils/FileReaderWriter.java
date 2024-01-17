package ru.learningJava.certification1.utils;

import ru.learningJava.certification1.model.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReaderWriter {

    public static String getUserFilePath(){
        String userFilePath = "src/main/java/ru/learningJava/certification1/utils/User.txt";
        return userFilePath;
    }

    public static void writeUsersToFile(List<User> userList){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getUserFilePath()))){
            userList.stream().forEach(user -> {
                try {
                    bufferedWriter.write(user + "");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public static void deleteAll (){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getUserFilePath()))){
            bufferedWriter.write("");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static List<User> getUsers(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getUserFilePath()))){
            List<User> userList = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null && line != ""){
                List<String> params = new ArrayList<>();
                Collections.addAll(params, line.split(","));
                User userFromFile = new User(params.get(0), LocalDate.parse(params.get(1)),params.get(2),params.get(3),params.get(4),params.get(5),params.get(6),params.get(7),Integer.parseInt(params.get(8)),Boolean.parseBoolean(params.get(9)));
                userList.add(userFromFile);
                line = bufferedReader.readLine();
            }
            return userList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
