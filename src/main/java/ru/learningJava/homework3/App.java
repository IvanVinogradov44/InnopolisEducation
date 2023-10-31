package ru.learningJava.homework3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        TV LG = new TV("LG",false,40.5);
        Scanner scaner = new Scanner(System.in);
        LG.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        LG.setScreenResolution("HD");

        TV panasonic = new TV("Panasonic", true,108);
        panasonic.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        panasonic.setScreenResolution("2K");


        System.out.println(LG);
        System.out.println();
        System.out.println(panasonic);

    }
}
