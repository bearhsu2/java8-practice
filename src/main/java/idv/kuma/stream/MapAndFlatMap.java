package idv.kuma.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {


    public static void main(String[] args) {
        // Map
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> lengths = words.stream().map(w -> w.length()).collect(Collectors.toList());
        System.out.println(lengths);


        // FlatMap

    }
}
