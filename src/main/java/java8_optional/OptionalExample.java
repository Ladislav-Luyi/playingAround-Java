package java8_optional;


import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;


 class Bar {

    private String foo;

    public Optional<String> getFoo() {

        return Optional.ofNullable(foo);

    }

}

public class OptionalExample {
    /*
    !!!
        A variable whose type is Optional should never itself be null; it should always point to an Optional instance.
        the method should return an empty Optional instead of null in all cases

        In general, an Optional should be used as a return value if:

            It is expected that a value may or may not be present
            It is not an error if a value is missing
            The client is responsible for handling the case of a missing value

        Of course, people will do what they want.
        But we did have a clear intention when adding this feature,
        and it was not to be a general purpose Maybe type, as much as many people
        would have liked us to do so. Our intention was to provide a limited mechanism for
        library method return types where there needed to be a clear way to represent "no result", and using
        null for such was overwhelmingly likely to cause errors. - see up example

        Optional do not support serializable interface, therefore do not used it as instance variable

        Do not used optional parameter as argument, instead used method overloading - two method one got and one not got argument
        or use another method - one which requeire argument, other which not require argument

        you can also introduced the null object - https://refactoring.guru/introduce-null-object

    !!!
     */

    // == START creation of optional objects ==
    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        Assert.assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "test";
        Optional<String> opt = Optional.of(name);
        Assert.assertTrue(opt.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional.of(name);
    }

    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        Assert.assertFalse(opt.isPresent());
    }

    // == STOP creation of optional objects ==


    // == Conditional ifPresent() ==
    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("test");
        opt.ifPresent(name -> System.out.println(name));
    }

    // == big OR part ==

        // == Conditional orElse() ==

        @Test
        public void whenOrElseWorks_thenCorrect() {
            String nullName = null;
            // v tomto pripade ofNullable pripusta, ze moze byt null object a ked je null object prejde na orElse
            String name = Optional.ofNullable(nullName).orElse("Laci");
            Assert.assertEquals("Laci", name);
        }

        // == Conditional orElseGet() ==

        @Test
        public void whenOrElseGetWorks_thenCorrect() {
            String nullName = null;
            // orElseGet using as input supplier function
            String name = Optional.ofNullable(nullName).orElseGet(() -> "Laci");
            Assert.assertEquals("Laci", name);
        }

        // == Conditional orElseThrow() ==

        @Test(expected = IllegalArgumentException.class)
        public void whenOrElseThrowWorks_thenCorrect() {
            String nullName = null;
            String name = Optional.ofNullable(nullName).orElseThrow(
                    IllegalArgumentException::new);
        }


    // == Conditional get() ==

    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> opt = Optional.of("Laci");
//        ...One of the few mistakes we made [in Java 8] was the naming of Optional.get(),
//        because the name just invites people to call it without calling isPresent(),
//        undermining the whole point of using Optional in the first place....
        String name = opt.get();
        Assert.assertEquals("Laci", name);
    }

    //there is flow if object is null then exception is thrown
    @Test(expected = NoSuchElementException.class)
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        Optional<String> opt = Optional.ofNullable(null);
        String name = opt.get();
    }
}
