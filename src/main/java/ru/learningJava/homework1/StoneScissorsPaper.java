package ru.learningJava.homework1;

import java.util.ArrayList;
import java.util.List;

public class StoneScissorsPaper {
    public static void main(String[] args) {
        int vasya = (int) (Math.random()*3);
        int petya = (int) (Math.random()*3);

        List<String> fingerSigns = new ArrayList<>();
        fingerSigns.add("Камень");
        fingerSigns.add("Ножницы");
        fingerSigns.add("Бумага");

        System.out.println("Vasya-"+ fingerSigns.get(vasya) + ", Petya-" + fingerSigns.get(petya));

        if (vasya == petya) {System.out.println("Ничья"); System.exit(0);}

        if (vasya == 0) if (petya == 1) System.out.println("Победил Vasya!");
            else System.out.println("Победил Petya");
        if (vasya == 1) if (petya == 2) System.out.println("Победил Vasya!");
            else System.out.println("Победил Petya");
        if (vasya == 2) if (petya == 0) System.out.println("Победил Vasya!");
            else System.out.println("Победил Petya");

    }
}
