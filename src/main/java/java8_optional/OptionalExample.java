package java8_optional;


import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;




public class OptionalExample {

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
