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
        Product product = new Product(getProductNameFromScaner(), getProductPriceFromScanner());

        Person sasha = new Person("Саша",500);
        Person alena = new Person("Алена",1500);
        Person ben = new Person("Бен",60);
        Person person = new Person(getPersonNameFromScaner(), getPersonMoneyFromScaner());

        List<Product> productList = new ArrayList<>();
        productList.add(milk);
        productList.add(bread);
        productList.add(beer);
        productList.add(chiken);
        productList.add(fish);
        productList.add(product);

        List<Person> visitors = new ArrayList<>();
        visitors.add(sasha);
        visitors.add(alena);
        visitors.add(ben);
        visitors.add(person);




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

    }



    public static String getPersonNameFromScaner(){
        System.out.println("Введите имя покупателя");
        Scanner scanPersonName = new Scanner(System.in);
        String personName = scanPersonName.nextLine();
        while (personName == "" || personName == null){
            System.out.println("Имя покупателя не может быть пустым");
            personName = scanPersonName.nextLine();
        }
        return personName;
    }

    public static int getPersonMoneyFromScaner(){
        System.out.println("Введите кол-во денег покупателя");
        Scanner scanPersonMoney = new Scanner(System.in);
        int personMoney = scanPersonMoney.nextInt();
        while (personMoney < 0){
            System.out.println("Кол-во денег не может быть отрицательным");
            personMoney = scanPersonMoney.nextInt();
        }
        return personMoney;
    }

    public static String getProductNameFromScaner() {
        System.out.println("Введите название продукта");
        Scanner scanProductName = new Scanner(System.in);
        String productName = scanProductName.nextLine();
        while (productName == "" || productName == null) {
            System.out.println("Названия продукта не может быть пустым");
            productName = scanProductName.nextLine();
        }
        return productName;
    }

    public static int getProductPriceFromScanner(){
        System.out.println("Введите цену продукта");
        Scanner scanProductPrice = new Scanner(System.in);
        int productPrice = scanProductPrice.nextInt();
        while (productPrice < 0){
            System.out.println("Цена продукта не может быть отрицательным");
            productPrice = scanProductPrice.nextInt();
        }
        return productPrice;
    }
}
