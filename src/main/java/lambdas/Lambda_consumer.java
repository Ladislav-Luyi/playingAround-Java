package lambdas;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Lambda_consumer {



    public static void main(String[] args) {


        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

        Consumer<List<Integer>> intPrinter = System.out::println;

        //because consumer has returning nothing; you have to access elements of the lists directly
        Consumer<List<Integer>> incrementWithOne = list -> {
            for(int i = 0; i < list.size();i++)
                list.set(i, list.get(i) + 1);
        };


        intPrinter.accept(values);

        incrementWithOne.accept(values);
        intPrinter.accept(values);

        intPrinter
                .andThen(incrementWithOne)
                .andThen(intPrinter)
                .accept(values);

    }



}
