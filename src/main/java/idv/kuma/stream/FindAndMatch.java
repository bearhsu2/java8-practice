package idv.kuma.stream;

public class FindAndMatch {

    public static void main(String[] args) {


        // any match
        if (Menu.menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("some are vegetarian friendly");
        }


        // all match
        if (Menu.menu.stream().allMatch(d -> d.getCalories() < 1000)) {
            System.out.println("all are thin (calories < 1000)");
        }

        // none match
        if (Menu.menu.stream().noneMatch(d -> d.getCalories() >= 1000)) {
            System.out.println("none is fat (calories >= 1000)");
        }


    }
}
