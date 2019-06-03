package idv.kuma.optional;

import java.util.Optional;

public class Main {


    public static void main(String[] args) {
        Car car = new Car(Optional.of(new Insurance("I1")));
        Optional<Car> optCar = Optional.ofNullable(car);

        String name = optCar.flatMap(c -> c.getInsurance())
                .map(i -> i.getName())
                .orElse("Unknown");

        System.out.println(name);
    }
}
