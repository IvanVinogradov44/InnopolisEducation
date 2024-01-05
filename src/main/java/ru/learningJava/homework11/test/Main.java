package ru.learningJava.homework11.test;

import ru.learningJava.homework11.model.Car;
import ru.learningJava.homework11.repository.CarRepositoryImpl;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.Arrays.compare;
import static java.util.Arrays.stream;

public class Main {

    public static void main(String[] args) throws IOException {

        CarRepositoryImpl carRepository = new CarRepositoryImpl();

        carRepository.getCarsFromFile();

        String color = "Black";
        carRepository.regNumberWithColorOrZeroMileage(color);

        int min = 0;
        int max = 1000000;
        carRepository.countUniqueModelInPriceRange(min,max);

        carRepository.colorOfChipestCar();

        String model = "Toyota";
        carRepository.AvgPriceOfModel(model);
    }
}
