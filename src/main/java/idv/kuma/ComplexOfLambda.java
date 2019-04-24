package idv.kuma;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComplexOfLambda {


    public static void main(String[] args) {
        List<Apple> inventory;

        // Comparator
        inventory = Arrays.asList(new Apple(10, "Green"),
                new Apple(13, "Red"),
                new Apple(3, "Yellow"),
                new Apple(3, "Black"));
        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed());
        System.out.println(inventory);

        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        System.out.println(inventory);

        // Predicate
        inventory = Arrays.asList(new Apple(10, "Green"),
                new Apple(13, "Red"),
                new Apple(50, "Red"),
                new Apple(3, "Yellow"),
                new Apple(3, "Black"));

        Predicate<Apple> redApple = a -> "Red".equalsIgnoreCase(a.getColor());

        Predicate<Apple> notRedAndHeavyOrBlack = redApple.negate().and(a -> a.getWeight() > 5).or(a -> a.getColor().equalsIgnoreCase("Black"));

        System.out.println(inventory.stream().filter(notRedAndHeavyOrBlack).collect(Collectors.toList()));

        

    }


}
