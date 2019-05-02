package idv.kuma.stream.numbers;

import idv.kuma.stream.Dish;
import idv.kuma.stream.Menu;

import java.beans.IntrospectionException;
import java.util.OptionalInt;
import java.util.stream.IntStream;

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
    }


}
