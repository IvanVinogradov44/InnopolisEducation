package ru.learningJava.homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int money;
    private List<Product> productsBag = new ArrayList<>();

    public Person() {
    }

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProductsBag() {
        return productsBag;
    }

    public void addProductsToBag(Product product) {
        this.productsBag.add(product);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money && Objects.equals(name, person.name) && Objects.equals(productsBag, person.productsBag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, productsBag);
    }

    @Override
    public String toString() {
        String template = "\n имя - %s, осталось денег - %d, покупки: %s";
        String productList = "Нет покупок";
        if (!getProductsBag().isEmpty()) {
            productList = String.format("Покупки: %s", getProductsBag().toString());
        }
        return String.format(template, getName(), getMoney(), productList);
    }
}
