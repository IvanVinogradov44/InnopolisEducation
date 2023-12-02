package ru.learningJava.homework4;

import java.util.Arrays;

public class SortChar {
    public static void main(String[] args) {
        String text = "sdrea troid uuitr";
        String[] words = text.split(" ");
        for(String word : words) {
            char[] unsortWord = word.toCharArray();
            Arrays.sort(unsortWord);
            System.out.println(unsortWord);
        }

    }
}
