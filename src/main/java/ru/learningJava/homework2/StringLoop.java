package ru.learningJava.homework2;

public class StringLoop {
    public static void main(String[] args) {
        String loopedWord = "";
        for (int i = 0; i < 8; i++){
            loopedWord = loopedWord + "Java";
        }
        System.out.println(loopedWord);
    }
}
