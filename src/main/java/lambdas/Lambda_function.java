package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Lambda_function {
    private static Function<String, String> mainFunction;

    private static void creatingMainFun(Function<String,String> ... functions){
        mainFunction = Arrays.stream(functions).reduce(Function::compose).orElse(string -> string);
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> appendingTmpToEachElement = input -> input + "tmp";



        list.stream()
                .peek(System.out::println)
                .map(toUpperCase)
                .forEach(System.out::println);


        // composition function example
        creatingMainFun(appendingTmpToEachElement,toUpperCase);

        list.stream()
                .peek(System.out::println)
                .map(mainFunction)
                .forEach(System.out::println);

        //apply pouzivas ked chces zavolat funkciu iba na jednu hodnotu
        System.out.println( mainFunction.apply("testInput") );
    }
}
