package idv.kuma.stream;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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

        // 3. create from file I/O
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {

            long count = lines.flatMap(l -> Arrays.stream(l.split(" ")))
                    .distinct()
                    .count();
            System.out.println(count);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}

