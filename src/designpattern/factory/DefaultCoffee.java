package designpattern.factory;

public class DefaultCoffee extends Coffee {

    private int price;

    public DefaultCoffee() {
        this.price = -1;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
