package idv.kuma.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static idv.kuma.lambda.PredicateExamples.filter;

public class ComparatorExamples {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(10, "green"), new Apple(5, "red"));
        List<Apple> greenApples = filter(inventory, apple -> apple.getColor().equals("green"));

        System.out.println(greenApples);

        // =======

        System.out.println(inventory);
        inventory.sort((a, b) -> a.getWeight() - b.getWeight());
        System.out.println(inventory);


        // =======

        List<Apple> inventory2 = Arrays.asList(new Apple(10, "green"), new Apple(5, "red"));
        System.out.println(inventory);
        inventory2.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
    }


}
