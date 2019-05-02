package idv.kuma.stream.numbers;

import idv.kuma.stream.Dish;
import idv.kuma.stream.Menu;

public class NumberStreams {

    public static void main(String[] args) {
        int sum = Menu.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);
    }


}
