package ru.learningJava.homework3;

import java.io.ObjectInputStream;
import java.util.*;

public class App {
    public static void main(String[] args) {

        System.out.println("Введите значение максимального уровня громкости");
        int maxVolume = -1;
        Scanner scanMaxVolume = new Scanner(System.in);
        while (maxVolume == -1) {
            int maxVolumeInput = scanMaxVolume.nextInt();
            if (maxVolumeInput < 100 && maxVolumeInput >0){
                maxVolume = maxVolumeInput;
                System.out.println("Максимальная громкость " + maxVolume);
            }
            else {
                System.out.println("Некорректно указана максимальная громкость");
            }
        }

        Random randomNumbers = new Random();

        TV TV1 = new TV("LG",true,40);
        TV1.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV1.setVolume();

        TV TV2 = new TV("AOC", true,32);
        TV2.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV2.setVolume(randomNumbers.nextInt(0, 100));

        TV TV3 = new TV("Горизонт", true,55);
        TV3.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV3.setVolume(randomNumbers.nextInt(0, 100));

        TV TV4 = new TV("Sony", true,78);
        TV4.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV4.setVolume(randomNumbers.nextInt(0, 100));

        TV TV5 = new TV("Samsung", true,69);
        TV5.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV5.setVolume(randomNumbers.nextInt(0, 100));

        TV TV6 = new TV("Xiaomi", true,75);
        TV6.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV6.setVolume(randomNumbers.nextInt(0, 100));

        TV TV7 = new TV("Polarline", true,11);
        TV7.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV7.setVolume(randomNumbers.nextInt(0, 100));

        TV TV8 = new TV("Philips", false,9);
        TV8.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV8.setVolume(randomNumbers.nextInt(0, 100));

        TV TV9 = new TV("NanoCell", false,99);
        TV9.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV9.setVolume(randomNumbers.nextInt(0, 100));

        TV TV10 = new TV("ASUS", false,66);
        TV10.setScreenFrequency(ScreenFrequncy.getRandomFrequncy());
        TV10.setVolume(randomNumbers.nextInt(0, 100));

        System.out.println("Максимальная громкость " + maxVolume);

        Scanner scanTV = new Scanner(System.in);
        TV[] TVList = new TV[10];
        TVList[0] = TV1;
        TVList[1] = TV2;
        TVList[2] = TV3;
        TVList[3] = TV4;
        TVList[4] = TV5;
        TVList[5] = TV6;
        TVList[6] = TV7;
        TVList[7] = TV8;
        TVList[8] = TV9;
        TVList[9] = TV10;

        Arrays.sort(TVList);

        System.out.println("Телевизоры  \n " +
                "Включены\n" +
                "с громкостью > " + maxVolume + "\n"+
                "Отсортированы по возрастанию включенного канала\n");

        for (int i = 0; i < TVList.length-1; i++)
            if (TVList[i].getIsOn() && TVList[i].getVolume()<= maxVolume)
                System.out.println(TVList[i]);



    }
}
