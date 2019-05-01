package idv.kuma.stream;

import java.util.Arrays;
import java.util.List;

import static idv.kuma.stream.Menu.menu;

public class FindAndMatch {

    public static void main(String[] args) {


        // any match
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("some are vegetarian friendly");
        }


        // all match
        if (menu.stream().allMatch(d -> d.getCalories() < 1000)) {
            System.out.println("all are thin (calories < 1000)");
        }

        // none match
        if (menu.stream().noneMatch(d -> d.getCalories() >= 1000)) {
            System.out.println("none is fat (calories >= 1000)");
        }

        // find any
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        integers.stream()
                .filter(i -> i % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println);



    }
}
