package idv.kuma.collector;

import idv.kuma.stream.Dish;
import idv.kuma.stream.Menu;

import java.util.stream.Collectors;

public class CollectorsExamples {

    public static void main(String[] args) {
        Integer sum1 = Menu.menu.stream()
                .map(d -> d.getCalories())
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum1);

        Integer sum2 = Menu.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum2);

        Integer sum3 = Menu.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum3);
    }
}
