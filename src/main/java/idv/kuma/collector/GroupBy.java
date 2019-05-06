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
            if (d.getCalories() > 400) return "FAT";
            return "THIN";
        }));
        System.out.println(groupByFunction);

        // 2-level grouping
        Map<Type, Map<String, List<Dish>>> twoLevels = Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(d -> {
            if (d.getCalories() > 400) return "FAT";
            return "THIN";
        })));
        System.out.println(twoLevels);

    }
}
