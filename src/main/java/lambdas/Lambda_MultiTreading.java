package lambdas;

public class Lambda_MultiTreading {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Howdy, world!");
        r.run();

        }


}
