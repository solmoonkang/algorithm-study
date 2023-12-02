package designpattern.strategy;

public class StrategyApplication {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item itemA = new Item("kundolA", 100);
        Item itemB = new Item("kundolB", 300);

        cart.addItem(itemA);
        cart.addItem(itemB);

        // pay by LUNACard
        cart.pay(new LUNACardStrategy("kundol@example.com", "pukubababo"));

        // pay by KAKAOCard
        cart.pay(new KAKAOCardStrategy("Kang solmoon", "123456789", "123", "12/01"));
    }
}
