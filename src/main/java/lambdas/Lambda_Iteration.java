package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Lambda_Iteration {
    static List<Person> people = new ArrayList<Person>();

    static{
        people.add(new Person("Laci",30,180));
        people.add(new Person("Dodo",27,182));
        people.add(new Person("Katka",28,178));
        people.add(new Person("Kubo",13,150));
        people.add(new Person("Peta",9,155));
        people.add(new Person("Linda",27,170));
    }

    public static void main(String[] args) {
        System.out.println("FILTER");
        System.out.println("FILTER ############################## working in stadard way");

        people.stream().filter(e -> e.age > 10).
                forEach(e -> System.out.println(e.name));

        System.out.println("FILTER ############################## working with predicates");
        Predicate<Person> agePredicate = e -> e.age > 10;
        Predicate<Person> heightPredicate = e -> e.height >= 170;

        people.stream().filter(agePredicate.and(heightPredicate))
            .forEach(e -> System.out.println(e.name));

        System.out.println("mapToInt ############################## return int stream from instance");
        System.out.println("in this case nothing happened");
        people.stream().mapToInt(e->e.age);

        System.out.println("using intStream to get sum number");
        int sum = people.stream().mapToInt(e->e.age).sum();
        System.out.println(sum);

        System.out.println("using intStream to get sum number2");
        IntStream basic = people.stream().mapToInt(e -> e.age);
        System.out.println( basic.sum() );

        System.out.println("using intStream to get count number");
        long count = people.stream().mapToInt(e->e.age).count();
        System.out.println( count );

        System.out.println("using intStream to get max number");
        OptionalInt max = people.stream().mapToInt(e->e.age).max();
        System.out.println(max.getAsInt());

        System.out.println("reduce ############################## reduce int stream to single number");
        int sum1 = people.stream().mapToInt(e->e.age).reduce(0, (l,r) -> l+r);
        System.out.println(sum1);

        System.out.println("peek ############################## reduce int stream to single number and show what is happening");
        int sum2 = people.stream().peek(System.out::println).mapToInt(e->e.age).reduce(0, (l,r) -> l+r);
        System.out.println(sum2);

        System.out.println("get ############################## get one element from list");
        Person person1 = people.stream().filter(p -> p.getAge() == 30).reduce( (a,b) -> { throw new IllegalStateException("Found multiple elements" + a + " " + b); } ).get();
        System.out.println(person1);

        try {
            Person person2 = people.stream().filter(p -> p.getAge() == 27).reduce((a, b) -> {
                throw new IllegalStateException("Found multiple elements" + a + " " + b);
            }).get();
            System.out.println(person2);
        } catch (IllegalStateException e){
            e.printStackTrace();
        }

        System.out.println("removeIf ############################## remove element from list");
        people.removeIf(p-> p.getAge() == 27);
        people.forEach(System.out::println);


    }


}
