package ru.learningJava.homework6;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("Молоко", 80);
        Product bread = new Product("Хлеб", 50);
        Product beer = new Product("Пиво", 200);
        Product chiken = new Product("Курица", 250);
        Product fish = new Product("Рыба", 500);
        //Product product = new Product(getProductNameFromScaner(), getProductPriceFromScanner());
        ProductDiscount sugar = new ProductDiscount("Сахар", 100,10);
        //ProductDiscount productDiscount = new ProductDiscount(getProductNameFromScaner(), getProductPriceFromScanner(),getDiscountFromScanner());

        Person sasha = new Person("Саша",500);
        Person alena = new Person("Алена",1500);
        Person ben = new Person("Бен",60);
        //Person person = new Person(getPersonNameFromScaner(), getPersonMoneyFromScaner());

        List<Product> productList = new ArrayList<>();
        productList.add(milk);
        productList.add(bread);
        productList.add(beer);
        productList.add(chiken);
        productList.add(fish);
        //productList.add(product);
        productList.add(sugar);
        //productList.add(productDiscount);


        List<Person> visitors = new ArrayList<>();
        visitors.add(sasha);
        visitors.add(alena);
        visitors.add(ben);
        //visitors.add(person);


        LinkedList<Person> queue = new LinkedList(visitors);
        Random randomProduct = new Random();

        while (!queue.isEmpty()){
            Person currentVisitor = queue.getFirst();
            Product currentProduct = productList.get(randomProduct.nextInt(productList.size()));
            if(currentVisitor.getMoney()>=currentProduct.getPrice()){
                currentVisitor.addProductsToBag(currentProduct);
                currentVisitor.setMoney(currentVisitor.getMoney() - currentProduct.getPrice());
                System.out.println(currentVisitor.getName() + " купил " + currentProduct.getProductName());
            }
            else{
                System.out.println(currentVisitor.getName() + " - не достаточно средств для покупки " + currentProduct.getProductName());
                queue.removeFirst();
            }
        }

        System.out.println(visitors);
        System.out.println(sugar.currentDate);
    }



    static String getPersonNameFromScaner(){
        System.out.println("Введите имя покупателя");
        Scanner scanPersonName = new Scanner(System.in);
        String personName = scanPersonName.nextLine();
        while (personName == "" || personName == null){
            System.out.println("Имя покупателя не может быть пустым");
            personName = scanPersonName.nextLine();
        }
        return personName;
    }

    static int getPersonMoneyFromScaner(){
        System.out.println("Введите кол-во денег покупателя");
        Scanner scanPersonMoney = new Scanner(System.in);
        int personMoney = scanPersonMoney.nextInt();
        while (personMoney < 0){
            System.out.println("Кол-во денег не может быть отрицательным");
            personMoney = scanPersonMoney.nextInt();
        }
        return personMoney;
    }

    static String getProductNameFromScaner() {
        System.out.println("Введите название продукта");
        String regex = "\\d+";
        Scanner scanProductName = new Scanner(System.in);
        String productName = scanProductName.nextLine();
        while (productName == "" || productName == null || productName.length() < 3 || productName.matches(regex)) {
            System.out.println("Названия продукта некорректно, введите снова");
            productName = scanProductName.nextLine();
        }
        return productName;
    }

    static int getProductPriceFromScanner(){
        System.out.println("Введите цену продукта");
        Scanner scanProductPrice = new Scanner(System.in);
        int productPrice = scanProductPrice.nextInt();
        while (productPrice <= 0){
            System.out.println("Цена продукта не может быть отрицательным");
            productPrice = scanProductPrice.nextInt();
        }
        return productPrice;
    }

    static int getDiscountFromScanner(){
        System.out.println("Введите величину скидки");
        Scanner scanDiscount = new Scanner(System.in);
        int discount = scanDiscount.nextInt();
        while (discount <= 0 || discount > 100){
            System.out.println("Величина скидки некорректна, введите снова");
            discount = scanDiscount.nextInt();
        }
        return discount;
    }
}
