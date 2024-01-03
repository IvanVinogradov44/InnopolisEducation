package ru.learningJava.homework6.utils;

public class Validator {
    public static <T extends Number> boolean lessZero(T number) {
        ByCondition condition = new ByCondition() {

            @Override
            public <T> boolean isOk(T number) {

                return (int) number < 0;
            }
        };

        return condition.isOk(number);
    }

    public static <T extends Number> boolean isCanBuy(T price, T currentMoney) {
        ByCondition condition = new ByCondition() {

            @Override
            public <T> boolean isOk(T number) {

                return (int) number >= 0;
            }
        };

        return condition.isOk((int) currentMoney - (int) price);
    }

}
