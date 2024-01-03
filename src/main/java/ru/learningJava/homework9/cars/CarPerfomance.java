package ru.learningJava.homework9.cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarPerfomance extends Car {
    private List<String> addOns = new ArrayList<>();

    public CarPerfomance() {
    }

    public CarPerfomance(String brand, String model, int yearOfCreation, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfCreation, horsePower, acceleration, suspension, durability);
    }

    public List<String> getAddOns() {
        return addOns;
    }


    public void setAddOns(String addOn) {
        this.addOns.add(addOn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarPerfomance that = (CarPerfomance) o;
        return Objects.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addOns);
    }

    @Override
    public String toString() {
        return "CarPerfomance - " +
                super.toString() +
                "addOns=" + addOns + "\n";
    }
}
