package ru.learningJava.homework9;

import java.util.List;
import ru.learningJava.homework9.cars.*;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(Car car) {

        this.parkedCars.add(car);
    }

    public CarPerfomance upgradeCar (CarPerfomance carPerfomance, String addOn){

        switch (addOn){
            case ("SportEngine"):
                upgradeEngine(carPerfomance);
                carPerfomance.setAddOns("SportEngine");
                break;
            case ("SportSuspension"):
                upgradeSuspension(carPerfomance);
                carPerfomance.setAddOns("SportSuspension");
                break;
        }

        return carPerfomance;
    }

    public CarPerfomance upgradeEngine(CarPerfomance carPerfomance){
        carPerfomance.setHorsePower(carPerfomance.getHorsePower()/10*15);
        return carPerfomance;
    }

    public void upgradeSuspension(CarPerfomance carPerfomance){
        carPerfomance.setSuspension(carPerfomance.getSuspension()/100*75);
    }
}
