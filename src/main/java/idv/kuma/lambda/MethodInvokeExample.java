package idv.kuma.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class MethodInvokeExample {

    static Map<String, BiFunction<Integer, String, Apple>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
    }

    public static Apple createApple(String name, Integer weight, String color) {
        return map.get(name).apply(weight, color);
    }

    public static void main(String[] args) {

        List<String> strings1 = Arrays.asList("12", "123");
        List<Integer> collect = strings1.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(collect);


        List<String> strings2 = Arrays.asList("a", "b", "A", "C");
        strings2.sort(String::compareToIgnoreCase);
        System.out.println(strings2);

        List<String> strings3 = Arrays.asList("aA", "bSF", "AA", "cC");
        List<String> lowerCases = strings3.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowerCases);


        Apple apple = createApple("apple", 34, "red");
        System.out.println(apple);
    }
}
