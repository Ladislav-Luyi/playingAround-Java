package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lambda_lightweight_strategy_pattern {

    public static int totalValues(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .mapToInt(value -> value)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(totalValues(values, value -> true));
        System.out.println(totalValues(values, value -> value % 2 == 0));
        System.out.println(totalValues(values, value -> value % 2 != 0));
    }
}
