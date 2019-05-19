package idv.kuma.collector;

import idv.kuma.stream.Dish;

import java.util.Comparator;
import java.util.stream.Collectors;

import static idv.kuma.stream.Menu.menu;

public class CollectorsExamples {

    public static void main(String[] args) {

        // sum
        Integer sum1 = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum1);

        Integer sum2 = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum2);

        Integer sum3 = menu.stream().mapToInt(Dish::getCalories).sum(); // the most recommended!!!
        System.out.println(sum3);

        Integer sum4 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(sum4);


        // min/max/average
        System.out.println(menu.stream().min(Comparator.comparingInt(Dish::getCalories)).get());
        System.out.println(menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories))).get());
        System.out.println(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)));

        // joining
        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(", ")));

        // groupBy/partitioningBy
        System.out.println(menu.stream().collect(Collectors.groupingBy(Dish::isVegetarian)));
        System.out.println(menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian)));

        



    }
}
