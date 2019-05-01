package idv.kuma.stream;

import java.util.Comparator;
import java.util.stream.Collectors;

public class StreamBasicPractice {

    public static void main(String[] args) {

        System.out.println(Menu.menu.stream()
                .filter(d -> d.getCalories() > 400)
                .sorted(Comparator.comparing(Dish::getName))
                .map(Dish::getName)
                .collect(Collectors.toList()));
    }
}
