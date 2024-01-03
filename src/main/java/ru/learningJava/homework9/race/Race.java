package ru.learningJava.homework9.race;

import ru.learningJava.homework9.cars.Car;

import java.util.List;
import java.util.Objects;

public abstract class Race {
    private int range;
    private String route;
    private int reward;
    private List<Car> members;

    private Car winner;

    public Race(int range, String route, int reward) {
        this.range = range;
        this.route = route;
        this.reward = reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return range == race.range && reward == race.reward && Objects.equals(route, race.route) && Objects.equals(members, race.members) && Objects.equals(winner, race.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(range, route, reward, members, winner);
    }

    @Override
    public String toString() {
        return  "range=" + range +
                ", route='" + route + '\'' +
                ", reward=" + reward +
                ", members=" + members +
                ", winner=" + winner +
                '}';
    }
}
