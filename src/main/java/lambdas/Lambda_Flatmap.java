package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Lambda_Flatmap {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("one:one"),
                Arrays.asList("two:one", "two:two", "two:three"),
                Arrays.asList("three:one", "three:two", "three:three", "three:four"));
        // flattering with foreach
        List<String> strings = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        strings.forEach(System.out::println);
    }
}
