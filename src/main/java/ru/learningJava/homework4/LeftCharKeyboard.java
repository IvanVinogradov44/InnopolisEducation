package ru.learningJava.homework4;


import java.util.Scanner;

public class LeftCharKeyboard {
    public static void main(String[] args) {

        String keyboardChar = "qwertyuiopasdfghjklzxcvbnm";

        Scanner scaner = new Scanner(System.in);
        String innerChar = scaner.next();

        int leftCharIndex = keyboardChar.indexOf(innerChar)-1;
        if (leftCharIndex != -1){
            System.out.println(keyboardChar.charAt(leftCharIndex));
        }
        else System.out.println("m");
    }


}
