package ru.learningJava.homework3;

import java.util.Random;

public enum ScreenFrequncy {
    frequncy_60(60),
    frequncy_75(75),
    frequncy_144(144),
    frequncy_175(175);

    public int getFrequncyValue() {
        return frequncyValue;
    }

    private int frequncyValue;
    @Override
    public String toString() {
        return Integer.toString(frequncyValue);
    }

    ScreenFrequncy(int frequncyValue) {
        this.frequncyValue = frequncyValue;
    }

    public static ScreenFrequncy getRandomFrequncy(){
        Random random = new Random();
        ScreenFrequncy[] values = ScreenFrequncy.values();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }
}
