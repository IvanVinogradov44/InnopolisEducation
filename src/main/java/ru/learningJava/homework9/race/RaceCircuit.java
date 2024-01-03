package ru.learningJava.homework9.race;

import ru.learningJava.homework9.race.Race;

import java.util.Objects;

public class RaceCircuit extends Race {
    private int laps;

    public RaceCircuit(int range, String route, int reward, int laps) {
        super(range, route, reward);
        this.laps = laps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RaceCircuit that = (RaceCircuit) o;
        return laps == that.laps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laps);
    }

    @Override
    public String toString() {
        return "RaceCircuit - " +
                super.toString() +
                "laps=" + laps + "\n";
    }
}
