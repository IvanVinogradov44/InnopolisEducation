package ru.learningJava.homework6;

public class PersonOld extends Person{
    public PersonOld(String name, int money) {
        super(name, money);
    }

    public int tryToBySmth(Product currentProduct){
        if (!currentProduct.isDiscountProduct()){
            System.out.println("Пенсионер не хочет покупать товары не по акции");
            return 1;
        }
        if(this.getMoney()>=currentProduct.getPrice()){
            this.addProductsToBag(currentProduct);
            this.setMoney(this.getMoney() - (int)(currentProduct.getPrice()-(currentProduct.getPrice()/100*5)));
            System.out.println(this.getName() + " купил " + currentProduct.getProductName());
            return  0;
        }
        else{
            System.out.println(this.getName() + " - не достаточно средств для покупки " + currentProduct.getProductName());
            return 1;
        }
    }
}
