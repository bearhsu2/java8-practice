package idv.kuma.stream;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
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

        // 3. create from file I/O
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {

            long count = lines.flatMap(l -> Arrays.stream(l.split(" ")))
                    .distinct()
                    .count();
            System.out.println(count);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 4. create from method
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        Stream.iterate(Arrays.asList(0, 1), l -> Arrays.asList(l.get(1), l.get(0) + l.get(1)))
                .limit(10)
                .forEach(l -> System.out.println(l.get(0)));

        // BAD example. It's not ok to have "status" in supplier
        IntStream.generate(new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = previous;
                int next = previous + current;
                previous = current;
                current = next;
                return oldPrevious;
            }
        }).limit(10).forEach(System.out::println);


    }
}

