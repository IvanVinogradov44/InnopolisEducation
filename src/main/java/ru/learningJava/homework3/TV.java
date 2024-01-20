package ru.learningJava.homework3;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

//public class TV implements Comparable<TV>{
//    private  String brandName;
//    private int channelCount;
//    private String screenResolution;
//    private ScreenFrequncy screenFrequency;
//    private String weight;
//    private int currentChannel;
//    private int volume = -1;
//    private boolean isOn;
//
//    public String getBrandName() {
//        return brandName;
//    }
//
//    public TV() {
//    }
//
//    //Конструктор
//    public TV (String brandName, boolean isOn, int currentChannel){
//        this.brandName = brandName;
//        Random randomNumber = new Random();
//        this.weight = String.format("%.2f",randomNumber.nextDouble(5,15));
//        this.channelCount = 100;
//        this.isOn = isOn;
//        this.currentChannel = currentChannel;
//    }
//    public void setScreenFrequency(ScreenFrequncy screenFrequency) {this.screenFrequency = screenFrequency;}
//
//    public void setScreenResolution(String screenResolution) {
//        this.screenResolution = screenResolution;
//    }
//
//    public void setVolume() {
//        System.out.println("Введите громкость " + this.brandName);
//        Scanner scanVolume = new Scanner(System.in);
//        while (volume == -1) {
//            int volumeValue = scanVolume.nextInt();
//            if (volumeValue > 100 || volumeValue < 0){
//                System.out.println("Некорректное значение громкости");
//            }
//            else {
//                this.volume = volumeValue;
//                System.out.println(this.brandName + " Громкость установлена " + this.volume);
//            }
//        }
//    }
//
//    public void setVolume(int volume){
//        this.volume = volume;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public boolean getIsOn() {
//        return isOn;
//    }
//
//    public int getCurrentChannel() {
//        return currentChannel;
//    }
//
//    @Override
//    public String toString() {
//        return "TV{" +
//                "brandName='" + brandName + '\'' +
//                ", currentChannel='" + currentChannel + '\'' +
//                ", volume=" + volume +
//                ", isOn=" + isOn +
//                ", channelCount=" + channelCount +
//                ", screenResolution='" + screenResolution + '\'' +
//                ", screenFrequency=" + screenFrequency +
//                ", weight='" + weight + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TV tv = (TV) o;
//        return channelCount == tv.channelCount && volume == tv.volume && isOn == tv.isOn && Objects.equals(brandName, tv.brandName) && Objects.equals(screenResolution, tv.screenResolution) && screenFrequency == tv.screenFrequency && Objects.equals(weight, tv.weight) && Objects.equals(currentChannel, tv.currentChannel);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(brandName, channelCount, screenResolution, screenFrequency, weight, currentChannel, volume, isOn);
//    }
//
//    @Override
//    public int compareTo(TV compare) {
//        int value = ((TV) compare).currentChannel;
//        return this.currentChannel - value;
//    }
//}
