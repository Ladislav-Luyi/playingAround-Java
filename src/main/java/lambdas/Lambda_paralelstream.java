package lambdas;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;

public class Lambda_paralelstream {
    private static List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    public void runParalelStream(){
        values.parallelStream().mapToInt(Lambda_paralelstream::compute).forEach(System.out::println);
    }

    private static int compute(Integer i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Computation heavy operation");
        return i;
    }
}
