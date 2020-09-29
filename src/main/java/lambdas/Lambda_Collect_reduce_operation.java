package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda_Collect_reduce_operation {

    static List<Person> people = new ArrayList<Person>();

    static{
        people.add(new Person("Laci",30,180));
        people.add(new Person("Dodo",27,182));
        people.add(new Person("Katka",27,178));
        people.add(new Person("Kubo",27,150));
        people.add(new Person("Peta",27,155));
        people.add(new Person("Linda",27,170));
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 1);

        System.out.println( "Example of to List \n" +
            values.stream().collect(Collectors.toList())
        );

        System.out.println( "Example of to Set \n" +
            values.stream().collect(Collectors.toSet())
        );

        System.out.println( "Example of to Map \n" +
            people.stream()
                .collect(Collectors.toMap(
                        k -> k.toString(), // lambda function to map key
                        v -> v.getHeight() // lambda function to map value
                ))
        );

        // output is hash with two set one which is true and one which is false
        System.out.println( "Example of to groupingBy 1  \n" +
                people.stream()
                        .collect(
                                Collectors.groupingBy(e -> e.getAge() == 30)
                        )
        );

        System.out.println( "Example of to groupingBy 2  \n" +
                people.stream()
                        .collect(
                                Collectors.groupingBy(e -> e.getAge())
                        )
        );


        System.out.println( "Example of to groupingBy 3 \n" +
                people.stream()
                        .collect(
                                Collectors.groupingBy(Person::getAge)
                        )
        );

        System.out.println( "Example of to groupingBy 4 - vsetci co maju rovnaky vek, zapis iba mena do listu a nie setu \n" +
                people.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge, //na zaklade coho zgroupujes
                                        Collectors.mapping( Person::getName, //ake values chces dat nie cela to string methoda
                                                            Collectors.toList() )))); // do coho chces dat
    }
}
