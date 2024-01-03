package ru.learningJava.homework6;

import ru.learningJava.homework6.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int money;
    private List<Product> productsBag = new ArrayList<>();
    protected int age;
    protected int creditPotential;

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



    public int tryToBySmth(Product currentProduct){
        if(Validator.isCanBuy(currentProduct.getPrice(), this.getMoney())){
            this.addProductsToBag(currentProduct);
            this.setMoney(this.getMoney() - currentProduct.getPrice());
            System.out.println(this.getName() + " купил " + currentProduct.getProductName());
            return  0;
        }
        else{
            System.out.println(this.getName() + " - не достаточно средств для покупки " + currentProduct.getProductName());
            return 1;
        }
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
        String template = "\n имя - %s, осталось денег : %d, Покупки: %s";
        String productList = "Нет покупок";
        if (!getProductsBag().isEmpty()) {
            productList = String.format("%s", getProductsBag().toString());
        }
        return String.format(template, getName(), getMoney(), productList);
    }
}
