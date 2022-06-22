package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciStream {
    public static void main(String[] args) {
        List<Integer> l = Stream.iterate(1, n -> n < 10, n -> n + 1).collect(Collectors.toList());

        List<Integer> l2 = Stream.iterate(1, n -> n + 1)
                .filter(n -> n % 2 == 1)
                .limit(10)
                .collect(Collectors.toList());

        // System.out.println(l2);

        Stream.iterate(new int[]{1, 1}, a -> new int[]{a[1], a[0] + a[1]})
            .limit(10)
            .map(a -> a[0])
            // .forEach(a -> System.out.println(Arrays.toString(a)));
            .forEach(System.out::println);

    }
}
