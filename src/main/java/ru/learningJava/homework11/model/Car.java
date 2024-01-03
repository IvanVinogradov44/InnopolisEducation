package ru.learningJava.homework11.model;

import java.util.Comparator;
import java.util.Objects;

public class Car implements Comparator{
    private String carRegNumber;
    private String model;
    private String color;
    private int mileage;
    private int price;

    public Car() {
    }

    public Car(String carRegNumber, String model, String color, int mileage, int price) {
        this.carRegNumber = carRegNumber;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage && price == car.price && Objects.equals(carRegNumber, car.carRegNumber) && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carRegNumber, model, color, mileage, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carRegNumber='" + carRegNumber + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}' + "\n";
    }
}
