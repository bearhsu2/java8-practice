package idv.kuma.stream;


import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {

        // 1. create from given values
        Stream<String> stringStream = Stream.of("I", "Love", "Java", "8", "lar", "!");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        // 2. create from array
        int[] numbers = {1, 4, 2, 6, 9, 3, 7, 0};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

    }
}
