package ru.learningJava.homework10.utils;

@FunctionalInterface
public interface ByCondition {
    <T> boolean  isOk(T number);
}
