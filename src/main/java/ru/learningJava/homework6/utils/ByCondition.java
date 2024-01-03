package ru.learningJava.homework6.utils;

@FunctionalInterface
public interface ByCondition {
    <T> boolean  isOk(T number);
}