package ru.learningJava.homework3;

import java.util.Random;

public class TV {
    private  String brandName;
    private int channelCount;
    private boolean isColored;
    private double diagonalSize;
    private String screenResolution;

    public ScreenFrequncy getScreenFrequency() {
        return screenFrequency;
    }

    public void setScreenFrequency(ScreenFrequncy screenFrequency) {
        this.screenFrequency = screenFrequency;
    }

    private ScreenFrequncy screenFrequency;
    private String weight;

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }


    public TV (String brandName, boolean isColored, double diagonalSize){
        this.brandName = brandName;
        this.isColored = isColored;
        this.diagonalSize = diagonalSize;
        Random randomNumber = new Random();
        this.weight = String.format("%.2f",randomNumber.nextDouble(5,15));
        this.channelCount = randomNumber.nextInt(10,100);
    }

    @Override
    public String toString() {
        return "TV{\n" +
                "brandName='" + brandName + "\n" +
                "channelCount=" + channelCount + "\n" +
                "isColored=" + isColored + "\n" +
                "diagonalSize=" + diagonalSize + "\n" +
                "screenResolution='" + screenResolution + "\n" +
                "screenFrequency='" + screenFrequency + "\n" +
                "weight=" + weight +
                '}';
    }
}
