package ru.learningJava.homework11.repository;

import ru.learningJava.homework11.model.Car;

import java.io.IOException;
import java.util.List;

public interface CarRepository {
    /**
     * Поиск номеров автомобилей заданного цвета или нулевой пробег
     * @param color искомый цвет
     */
    void regNumberWithColorOrZeroMileage (String color);

    /**
     * Поиск уникальных моделей в заданном ценовом диапазоне
     * @param min минимальная искомая цена
     * @param max максимальная искомая цена
     */
    void countUniqueModelInPriceRange (int min, int max);

    /**
     *Поиск цвета самого дешевого автомобиля
     */
    void colorOfChipestCar ();

    /**
     * Поиск средней цены модели
     * @param model искомая модель
     */
    void AvgPriceOfModel (String model);

    /**
     * Запись результатов в файл
     * @param text вводимый текст
     */
    void putInfoToFile(String text);

    /**
     * Получение данных из файла
     */
    void getCarsFromFile();
}
