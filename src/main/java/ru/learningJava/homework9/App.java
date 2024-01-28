package ru.learningJava.homework9;

import ru.learningJava.homework9.race.*;
import ru.learningJava.homework9.cars.*;
import ru.learningJava.homework9.utils.FileWorker;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        List<Car> carList = new ArrayList<>();
        List<Race> raceList = new ArrayList<>();

        Garage westCoastCustoms = new Garage();

        FileWorker.getInfoFromFile(carList, raceList, westCoastCustoms);
        FileWorker.putInfoToFile(carList,raceList);



        westCoastCustoms.upgradeCar((CarPerfomance) carList.get(0),"SportEngine");


    }
}
