package idv.kuma.collector;

import idv.kuma.stream.Dish;
import idv.kuma.stream.Menu;
import idv.kuma.stream.Type;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupAndPartition {

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

        // grouping mix other collectors
        Map<Type, Long> counting = Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(counting);

        Map<Type, Optional<Dish>> fattestOpt = Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(fattestOpt);

        Map<Type, String> fattest = Menu.menu
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparingInt(Dish::getCalories)),
                                        o -> o.get().getName()
                                )
                        )
                );
        System.out.println(fattest);

        // partitioning
        Map<Boolean, List<Dish>> isVeg = Menu.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(isVeg);


    }
}
