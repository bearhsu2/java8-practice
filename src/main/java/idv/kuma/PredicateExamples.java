package idv.kuma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class PredicateExamples {


    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> evenNumbers = filter(numbers, i -> i % 2 == 0);
        System.out.println(evenNumbers);


        List<String> strings = Arrays.asList("aa", "", "cc", "", "ee");
        List<String> nonEmptyStrings = filter(strings, s -> !s.isEmpty());
        System.out.println(nonEmptyStrings);




        System.out.println(strings.stream().filter( s -> !s.isEmpty()).collect(Collectors.toList()));

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();

        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;

    }
}
