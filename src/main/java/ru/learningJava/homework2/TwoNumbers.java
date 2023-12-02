package ru.learningJava.homework2;

import java.util.Scanner;

import static java.lang.Math.abs;

public class TwoNumbers {
    public static void main(String[] args) {
        Scanner getNumber = new Scanner(System.in);
        System.out.println("Введите первое число");
        int firstNumber = getNumber.nextInt();
        System.out.println("Введите второе число");
        int secondNumber = getNumber.nextInt();
        System.out.println("Певое число = " + firstNumber + ", Второе число = " + secondNumber);
        System.out.println("Сумма чисел = " + (firstNumber + secondNumber));
        System.out.println("Разница чисел = " + (firstNumber - secondNumber));
        System.out.println("Произведение чисел = " + (firstNumber * secondNumber));
        System.out.println("Среднее значение = " + (double) (firstNumber + secondNumber) / 2);
        System.out.println("Расстояние = " + (abs(firstNumber - secondNumber)));
        if (firstNumber > secondNumber) {
            System.out.println("Максимальное значение = " + firstNumber);
            System.out.println("Минимальное значение = " + secondNumber);
        }
        else {
            System.out.println("Максимальное значение = " + secondNumber);
            System.out.println("Минимальное значение = " + firstNumber);
        }
    }
}
