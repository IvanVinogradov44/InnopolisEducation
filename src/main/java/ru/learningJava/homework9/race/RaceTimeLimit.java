package ru.learningJava.homework9.race;

import ru.learningJava.homework9.race.Race;

import java.util.Objects;

public class RaceTimeLimit extends Race {
    private int goldTime;

    public RaceTimeLimit(int range, String route, int reward, int goldTime) {
        super(range, route, reward);
        this.goldTime = goldTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RaceTimeLimit that = (RaceTimeLimit) o;
        return goldTime == that.goldTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), goldTime);
    }

    @Override
    public String toString() {
        return "RaceTimeLimit{" +
                super.toString() +
                "goldTime=" + goldTime + "\n";
    }
}
