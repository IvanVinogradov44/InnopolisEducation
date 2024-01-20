package ru.learningJava.homework9.race;

import ru.learningJava.homework9.race.Race;

public class RaceDrift extends Race {

    public RaceDrift(int range, String route,int reward) {

        super(range, route, reward);
    }

    @Override
    public String toString() {

        return "RaceDrift - " + super.toString() + "\n";
    }
}
