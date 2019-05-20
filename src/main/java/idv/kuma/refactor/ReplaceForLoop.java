package idv.kuma.refactor;

import idv.kuma.stream.Dish;
import idv.kuma.stream.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceForLoop {

    public static void main(String[] args) {


        // Before
        List<String> fatDishes = new ArrayList<>();
        for (Dish dish : Menu.menu) {
            if (dish.getCalories() > 300) {
                fatDishes.add(dish.getName());
            }
        }
        System.out.println(fatDishes);


        // After
        System.out.println(Menu.menu.parallelStream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList()));

    }
}
