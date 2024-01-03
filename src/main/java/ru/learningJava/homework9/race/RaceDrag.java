package ru.learningJava.homework9.race;

import ru.learningJava.homework9.race.Race;

public class RaceDrag extends Race {

    public RaceDrag(int range, String route, int reward) {

        super(range, route,reward);
    }

    @Override
    public String toString() {

        return "RaceDrag - " + super.toString() + "\n";
    }
}
