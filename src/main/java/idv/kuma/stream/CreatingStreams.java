package idv.kuma.stream;


import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {

        // create from given values
        Stream<String> stringStream = Stream.of("I", "Love", "Java", "8", "lar", "!");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

    }
}
