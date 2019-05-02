package idv.kuma.stream.numbers;

import idv.kuma.stream.Dish;
import idv.kuma.stream.Menu;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStreams {

    public static void main(String[] args) {
        int sum = Menu.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);


        OptionalInt optionalMax = Menu.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(optionalMax.orElse(-1));


        IntStream evenStream = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);
        System.out.println(evenStream.count());

        System.out.println(IntStream.rangeClosed(1, 100).max());
        System.out.println(IntStream.range(1, 100).max());

        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
                IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b ->
                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        stream.limit(5)
                .forEach(t -> System.out.println(Arrays.stream(t)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(","))));
    }


}
