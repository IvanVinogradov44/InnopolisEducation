package ru.learningJava.homework2;

import java.util.Scanner;

public class fahrenheitToCelsius {

    public static void main(String[] args) {
        Scanner readerFahrenheitValue = new Scanner(System.in);

        System.out.println("Введите значение температуры по шкале Фаренгейта");
        double fahrenheitValue = readerFahrenheitValue.nextDouble();
        System.out.println("Введенное значение эквивалентно " + fToc(fahrenheitValue) + "градусам цельсия");

    }


    public static double fToc(double fahrenheitValue) {
        double celsiusValue;
        celsiusValue = (fahrenheitValue - 32) * 5/9;
        return celsiusValue;
    }

}
