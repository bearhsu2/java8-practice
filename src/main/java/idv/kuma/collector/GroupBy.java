package idv.kuma.collector;

import idv.kuma.stream.Dish;
import idv.kuma.stream.Menu;
import idv.kuma.stream.Type;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {

    public static void main(String[] args) {

        // by existing function
        Map<Type, List<Dish>> typeToDishes = Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(typeToDishes);

        // by anonymous function
        Map<String, List<Dish>> groupByFunction = Menu.menu.stream().collect(Collectors.groupingBy(d -> {
            if (d.getCalories() > 540) return "FAT";
            return "THIN";
        }));
        System.out.println(groupByFunction);

    }
}
