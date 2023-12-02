package designpattern.strategy;

public class KAKAOCardStrategy implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dataOfExpiry;

    public KAKAOCardStrategy(String name,
                             String cardNumber,
                             String cvv,
                             String dataOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dataOfExpiry = dataOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using KAKAOCard.");
    }
}
