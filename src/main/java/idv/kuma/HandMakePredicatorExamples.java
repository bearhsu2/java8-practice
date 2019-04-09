package idv.kuma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Hello world!
 */
public class HandMakePredicatorExamples {


    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> evenNumbers = filter(numbers, i -> i % 2 == 0);


        System.out.println(evenNumbers);
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
