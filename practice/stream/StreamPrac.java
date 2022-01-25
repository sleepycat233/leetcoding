package practice.stream;

import java.util.*;
import java.util.stream.*;

public class StreamPrac {
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String n, Gender g) {
            this.name = n;
            this.gender = g;
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
            new Person("Alex", Gender.MALE),
            new Person("Amy", Gender.FEMALE),
            new Person("Bob", Gender.MALE)
        );

        persons.stream()
            .filter(x -> Gender.MALE.equals(x.gender))
            .collect(Collectors.toList())
            .forEach(System.out::println);
    }
}
