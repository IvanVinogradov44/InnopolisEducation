package ru.learningJava.homework9;

import org.junit.jupiter.api.*;
import ru.learningJava.homework9.cars.CarPerfomance;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    CarPerfomance testCar;
    Garage garage = new Garage();

    @BeforeEach
    void setUp (){
        testCar = new CarPerfomance("TestBrand", "TestModel", 2000, 100, 100, 100, 100);
    }

    @Test
    @DisplayName("Проверка установки спортивного двигателя")
    void upgradeCarEngine() {
        garage.upgradeCar(testCar, "SportEngine");
        Assertions.assertEquals(150, testCar.getHorsePower());
    }

    @Test
    @DisplayName("Проверка установки спортивной подвески")
    void upgradeCarSuspension() {
        garage.upgradeCar(testCar, "SportSuspension");
        Assertions.assertEquals(75, testCar.getSuspension());
    }
}