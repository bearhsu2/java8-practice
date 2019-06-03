package idv.kuma.optional;

import java.util.Optional;
import java.util.function.IntUnaryOperator;

public class Main {


    public static void main(String[] args) {

        // Basic operations
        Car car = new Car(Optional.of(new Insurance("I1")));
        Optional<Car> optCar = Optional.ofNullable(car);

        String name = optCar.flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");

        System.out.println(name);




        // Getting values
        System.out.println(car.getInsurance().get());

        Car emptyCar = new Car(Optional.ofNullable(null));
        System.out.println(car.getInsurance().orElse(new Insurance("Default")));
        System.out.println(emptyCar.getInsurance().orElse(new Insurance("Default")));

        System.out.println(car.getInsurance().orElseGet(() -> new Insurance("Default")));
        System.out.println(emptyCar.getInsurance().orElseGet(() -> new Insurance("Default")));

        try {
            emptyCar.getInsurance().orElseThrow(() -> new RuntimeException("hahaha"));
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        car.getInsurance().ifPresent(System.out::println);
        emptyCar.getInsurance().ifPresent(System.out::println);
    }
}
