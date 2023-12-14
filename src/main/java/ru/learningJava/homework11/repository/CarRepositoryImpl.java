package ru.learningJava.homework11.repository;

import ru.learningJava.homework11.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CarRepositoryImpl implements CarRepository{

    String inputFilePath = "src/main/java/ru/learningJava/homework11/data/cars.txt";
    String outPutFilePath = "src/main/java/ru/learningJava/homework11/data/outPut.txt";
    List<Car> carList = new ArrayList<>();

    @Override
    public void regNumberWithColorOrZeroMileage(String color) {
            //1 стрим для поиска по заданному цвету и пробегу
            String colorToFindWithMileage = "Black";
            int mileageToFind = 0;
            Stream <String> colorAndMiliageStream =
                    carList
                    .stream()
                    .filter(car -> car.getColor().equals(colorToFindWithMileage) || car.getMileage() == mileageToFind)
                    .map(car -> car.getCarRegNumber());

        putInfoToFile("1 стрим для поиска по заданному цвету и пробегу \n");
        colorAndMiliageStream.forEach(str -> {
            putInfoToFile(str + "\n");
        });
    }

    @Override
    public void countUniqueModelInPriceRange(int min, int max) {
        putInfoToFile("2 стрим для поиска количества уникальных моделей в заданном ценовом диапазоне \n");
        int minPrice = 0;
        int maxPrice = 1000000;
        putInfoToFile("Моделей в ценовом диапазоне: " + carList.stream().filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice).map(car -> car.getModel()).distinct().count() + "\n");
    }

    @Override
    public void colorOfChipestCar() {
        putInfoToFile("3 Стрим для поиска цвета автомобиля с минимальной стоимостью.\n");
        putInfoToFile(carList.stream().min(Comparator.comparingInt(Car::getPrice)).map(car -> car.getColor()).get() + "\n");
    }

    @Override
    public void AvgPriceOfModel(String model) {
        putInfoToFile("4 Стрим для опредения Средней стоимости искомой модели modelToFind\n");
        String modelToFind = "Toyota";
        putInfoToFile("" + carList.stream().filter(car -> car.getModel().equals(modelToFind)).mapToDouble(car -> car.getPrice()).average().getAsDouble());
    }

    @Override
    public void putInfoToFile(String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPutFilePath, true))){
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getCarsFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))){
            String line = bufferedReader.readLine();
            while (line != null){
                List<String> params = new ArrayList<>();
                Collections.addAll(params, line.split("\\|"));
                line = bufferedReader.readLine();
                Car car = new Car(params.get(0), params.get(1), params.get(2), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)));
                carList.add(car);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
