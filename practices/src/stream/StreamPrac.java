package stream;

import static stream.StreamPrac.Gender.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPrac {
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String n, Gender g) {
            this.name = n;
            this.gender = g;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " " + gender;
        }
    }

    enum Gender {
        MALE, FEMALE
    }

    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("Alex", MALE),
            new Person("Amy", FEMALE),
            new Person("Bob", MALE)
        );

/*         Collector<Person, ?, List<Person>> col = Collectors.toList();
        Predicate<? super Person> predicate = x -> MALE.equals(x.gender);
        Consumer<? super Person> action = System.out::println;
        persons.stream()
            .filter(predicate)
            .collect(col)
            .forEach(action);
 */

        persons.stream()
            .map(p -> p.gender)
            .collect(Collectors.toList())
            .forEach(System.out::println);

        persons.stream()
            .map(p -> p.name)
            .mapToInt(String::length)
            // .boxed()
            // .collect(Collectors.toList())
            .forEach(System.out::println);

    }
}
