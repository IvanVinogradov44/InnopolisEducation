package ru.learningJava.homework9.cars;

import java.util.Objects;

public class CarShow extends Car {
    private int stars;

    public CarShow() {
    }

    public CarShow(String brand, String model, int yearOfCreation, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfCreation, horsePower, acceleration, suspension, durability);
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarShow carShow = (CarShow) o;
        return stars == carShow.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }

    @Override
    public String toString() {
        return "CarShow - " +
                super.toString() +
                "stars=" + stars + "\n";
    }
}
