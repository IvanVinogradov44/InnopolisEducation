package ru.learningJava.homework9.cars;

import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
public abstract class Car {
    private String brand;
    private String model;
    private int yearOfCreation;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

//    public Car() {
//    }

//    public Car(String brand, String model, int yearOfCreation, int horsePower, int acceleration, int suspension, int durability) {
//        this.brand = brand;
//        this.model = model;
//        this.yearOfCreation = yearOfCreation;
//        this.horsePower = horsePower;
//        this.acceleration = acceleration;
//        this.suspension = suspension;
//        this.durability = durability;
//    }

//    public void setHorsePower(int horsePower) {
//        this.horsePower = horsePower;
//    }
//
//    public int getSuspension() {
//        return suspension;
//    }
//
//    public void setSuspension(int suspension) {
//        this.suspension = suspension;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return yearOfCreation == car.yearOfCreation && horsePower == car.horsePower && acceleration == car.acceleration && suspension == car.suspension && durability == car.durability && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(brand, model, yearOfCreation, horsePower, acceleration, suspension, durability);
//    }
//
//    @Override
//    public String toString() {
//        return  "brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", yearOfCreation=" + yearOfCreation +
//                ", horsePower=" + horsePower +
//                ", acceleration=" + acceleration +
//                ", suspension=" + suspension +
//                ", durability=" + durability +
//                '}';
//    }
}