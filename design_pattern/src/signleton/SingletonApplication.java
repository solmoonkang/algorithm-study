package signleton;

public class SingletonApplication {

    public static void main(String[] args) {
        Singleton singletonA = Singleton.getInstance();
        Singleton singletonB = Singleton.getInstance();

        System.out.println(singletonA.hashCode());
        System.out.println(singletonB.hashCode());

        if (singletonA == singletonB) {
            System.out.println(true);
        }
    }
}
