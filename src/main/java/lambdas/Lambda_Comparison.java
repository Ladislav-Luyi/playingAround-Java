package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda_Comparison {
    static List<Person> people = new ArrayList<Person>();

    static{
        people.add(new Person("Laci",30,180));
        people.add(new Person("Dodo",27,182));
        people.add(new Person("Katka",28,178));
        people.add(new Person("Adam",13,150));
        people.add(new Person("Peta",9,155));
        people.add(new Person("Linda",27,170));
    }

    public static void main(String[] args) {

        System.out.println("################## - just iteration");
        people.stream().forEach(System.out::println);
        System.out.println("################## - comparing accoring name abcd");

        Collections.sort(people, Comparator.comparing(Person::getName) );
//        takto to nejde pisat ako si dole zacal
//        Collections.sort(people, Comparator.comparing((a,e) -> a.name.compareTo(e)) );
        people.stream().forEach(System.out::println);

        System.out.println("################## - comparing according age and then name");
        Collections.sort( people, Comparator.comparing(Person::getAge).thenComparing(Person::getName) );

        people.stream().forEach(System.out::println);
    }
}
