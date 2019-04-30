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
        String[] array = {"Goodbye", "WOrld"};
        List<String> collect = Arrays.stream(array).map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect);


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect1 = numbers1.stream()
                .flatMap((i -> numbers2.stream().map(j -> new int[]{i, j})))
                .collect(Collectors.toList());

        collect1.forEach(System.out::println);


    }
}
