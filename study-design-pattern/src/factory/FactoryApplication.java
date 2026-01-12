package factory;

public class FactoryApplication {

    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee americano = CoffeeFactory.getCoffee("Americano", 3000);

        System.out.println("Factory Latte ::" + latte);
        System.out.println("Factory Americano ::" + americano);
    }
}
