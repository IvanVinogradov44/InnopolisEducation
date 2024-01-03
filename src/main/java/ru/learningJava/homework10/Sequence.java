package ru.learningJava.homework10;

import ru.learningJava.homework10.utils.ByCondition;

import java.util.Arrays;

public class Sequence {
    public static void printSequence(int[] intArray) {
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(filter(intArray, new ByCondition() {
            @Override
            public <T>boolean isOk(T number) {
                return (int) number % 2 == 0;
            }
        })));

        System.out.println(Arrays.toString(filter(intArray, new ByCondition() {
            @Override
            public <T> boolean isOk(T number) {
                String currentNumber = "" + number;
                int sumChars = 0;
                for (int i = 0; i < currentNumber.length(); i++) {
                    sumChars = sumChars + currentNumber.charAt(i);
                }
                return sumChars % 2 == 0;

            }
        })));

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        System.out.println(i);
        System.out.println(s);
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }

    public static Integer[] filter(int[] intArray, ByCondition condition) {
        Integer[] filtredArrayBuf = new Integer[intArray.length];
        int j = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (condition.isOk(intArray[i])) {
                filtredArrayBuf[j] = intArray[i];
                j++;
            }
        }

        Integer[] filtredArray = new Integer[j];
        for (int i = 0; i < j; i++) {
            filtredArray[i] = filtredArrayBuf[i];
        }
        return filtredArray;
    }


//    public static int[] sumCharEachNumbers(int[] intArray, ByCondition condition){
//        int[] sumCharEachNumbersArray = new int[intArray.length];
//        String numberFromArray;
//        for (int i = 0; i < intArray.length; i++) {
//            numberFromArray = "" + intArray[i];
//            int sumChars = 0;
//            for (int j = 0; j <numberFromArray.length() ; j++) {
//                sumChars = sumChars + Character.getNumericValue(numberFromArray.charAt(j));
//                if (condition.isOk(intArray[i])) {
//                    sumCharEachNumbersArray[i] = intArray[i];
//                }
//            }
//        }
//        return sumCharEachNumbersArray;
//    }
}
