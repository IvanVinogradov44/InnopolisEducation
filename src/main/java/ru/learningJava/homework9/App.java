package ru.learningJava.homework9;

import ru.learningJava.homework9.race.*;
import ru.learningJava.homework9.cars.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        List<Car> carList = new ArrayList<>();
        List<Race> raceList = new ArrayList<>();

        Garage westCoastCustoms = new Garage();

        getInfoFromFile(carList, raceList, westCoastCustoms);
        putInfoToFile(carList,raceList);



        westCoastCustoms.upgradeCar((CarPerfomance) carList.get(0),"SportEngine");


    }

    public static void getInfoFromFile(List<Car> carList, List<Race> raceList,Garage westCoastCustoms) throws IOException {
        String inputFilePath = "src/main/java/ru/learningJava/homework9/Input.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                ArrayList<String> params = new ArrayList<>();
                Collections.addAll(params, line.split(","));
                line = bufferedReader.readLine();

                switch (params.get(0)) {
                    case ("CarPerfomance"):
                        CarPerfomance carPerfomance = new CarPerfomance(params.get(1), params.get(2), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)), Integer.parseInt(params.get(5)), Integer.parseInt(params.get(6)), Integer.parseInt(params.get(7)));
                        westCoastCustoms.setParkedCars(carPerfomance);
                        break;
                    case ("CarShow"):
                        CarShow carShow = new CarShow(params.get(1), params.get(2), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)), Integer.parseInt(params.get(5)), Integer.parseInt(params.get(6)), Integer.parseInt(params.get(7)));
                        westCoastCustoms.setParkedCars(carShow);
                        break;
                    case ("RaceCasual"):
                        RaceCasual raceCasual = new RaceCasual(Integer.parseInt(params.get(1)), params.get(2), Integer.parseInt(params.get(3)));
                        raceList.add(raceCasual);
                        break;
                    case ("RaceCircuit"):
                        RaceCircuit raceCircuit = new RaceCircuit(Integer.parseInt(params.get(1)), params.get(2), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)));
                        raceList.add(raceCircuit);
                        break;
                    case ("RaceDrag"):
                        RaceDrag raceDrag = new RaceDrag(Integer.parseInt(params.get(1)), params.get(2), Integer.parseInt(params.get(3)));
                        raceList.add(raceDrag);
                        break;
                    case ("RaceDrift"):
                        RaceDrift raceDrift = new RaceDrift(Integer.parseInt(params.get(1)), params.get(2), Integer.parseInt(params.get(3)));
                        raceList.add(raceDrift);
                        break;
                    case ("RaceTimeLimit"):
                        RaceTimeLimit raceTimeLimit = new RaceTimeLimit(Integer.parseInt(params.get(1)), params.get(2), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)));
                        break;

                }
            }
        }
    }

    //Не понял почему при кажом вызове, этот метод перезаписывает весь файл а не просто добавляет в него записи
    public static void putInfoToFile(List<Car> carList,List<Race> raceList) throws IOException {
        String outputFilePath = "src/main/java/ru/learningJava/homework9/OutPut.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            bufferedWriter.write("Cars:\n");
            bufferedWriter.write(carList.toString());
            bufferedWriter.write("Race:\n");
            bufferedWriter.write(raceList.toString());
        }
    }
}
