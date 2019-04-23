package idv.kuma;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComplexOfLambda {


    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(10, "Green"),
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
    }


}
