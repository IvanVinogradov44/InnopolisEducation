package ru.learningJava.homework6;

import java.util.Objects;

public class Product {
    private String productName;
    protected int price;
    protected boolean isDiscountProduct;
    protected boolean isKidAvailable;

    public Product(String productName, int price, boolean isKidAvailable) {
        this.productName = productName;
        this.price = price;
        this.isKidAvailable = isKidAvailable;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isDiscountProduct() {
        return isDiscountProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }

    @Override
    public String toString() {
        return  productName + '\'';
    }
}
