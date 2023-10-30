package ru.learningJava.practice;

public class Main {
    public static void main(String[] args) {
        Fruit apple = new Fruit("Apple");
        System.out.println(apple.name);
        Fruit mango = new Fruit();
        System.out.println(mango.name);
        mango.color = "green";
        System.out.println(mango.color);
    }
}
