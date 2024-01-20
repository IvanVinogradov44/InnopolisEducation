package ru.learningJava.homework12.utils;

import ru.learningJava.homework12.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {

    public static void putInfoToFiles(String lineToWrite, String secondName) throws IOException {
        String outPutFile = "src/main/java/ru/learningJava/homework12/persons/" + secondName + ".txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(outPutFile, true))) {
            File personFile = new File(outPutFile);
            if (!personFile.exists()) {
                System.out.println("Файл с такой фамилией не существует, создаем");
            }

            String personinfo = (lineToWrite + "\n");
            bufferedWriter.write(personinfo);
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
