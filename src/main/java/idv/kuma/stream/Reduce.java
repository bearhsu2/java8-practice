package idv.kuma.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 8);

        // sum
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        // max
        Optional<Integer> max = numbers.stream().reduce((a, b) -> a > b ? a : b);
        System.out.println(max.get());

        // count
        int count = numbers.stream().map(n -> 1).reduce(0, (a, b) -> a + b);
        System.out.println(count);


    }
}
