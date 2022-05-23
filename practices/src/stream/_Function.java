package stream;

import java.util.function.*;

public class _Function {
    public static void main(String[] args) {
        Function<Integer, Integer> increment = (a) -> a+1;
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a+b;

        System.out.println(sum.apply(1, 3));
    }
}
