package ru.learningJava.homework6;

public class PersonKid extends Person{
    public PersonKid(String name, int money, int age) {
        super(name, money);
        this.age = age;
    }

    @Override
    public int tryToBySmth(Product currentProduct){
        if (this.age< 6){
            System.out.println(this.getName() + " Запрещена продажа товаров детям до 6 лет");
            return 1;
        }

        if(this.getMoney()>=currentProduct.getPrice()){
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
}
