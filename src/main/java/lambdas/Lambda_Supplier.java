package lambdas;

import java.util.function.DoubleSupplier;


public class Lambda_Supplier {

    public static void main(String[] args) {
        DoubleSupplier doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier2.getAsDouble());


    }
}
