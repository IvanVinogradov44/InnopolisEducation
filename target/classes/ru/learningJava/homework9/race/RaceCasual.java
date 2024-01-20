package ru.learningJava.homework9.race;

public class RaceCasual extends Race {

    public RaceCasual(int range, String route, int reward) {

        super(range, route, reward);
    }

    @Override
    public String toString() {

        return "RaceCasual - " + super.toString() + "\n";
    }
}
