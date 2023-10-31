package ru.learningJava.homework4;

public class FindArrow {
    public static void main(String[] args) {
        String text = "<--<<>>-->>>-<--<<->>>--><-<--<<-<<";
        String text2 = text;
        String leftArrow = "<--<<";
        String rightArrow = ">>-->";
        int i = 0;
        while (text.indexOf(leftArrow) != -1) {
            text = text.replaceFirst(leftArrow, " ");
            i++;
        }
        while (text2.indexOf(rightArrow) != -1) {
            text2 = text2.replaceFirst(rightArrow, " ");
            i++;
        }
        System.out.println(i);
    }
}
