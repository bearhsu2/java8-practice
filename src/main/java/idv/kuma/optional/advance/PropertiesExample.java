package idv.kuma.optional.advance;

import java.util.Optional;
import java.util.Properties;

public class PropertiesExample {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("a", "5");
        properties.setProperty("b", "true");
        properties.setProperty("c", "-3");


        System.out.println(readDuration(properties, "a"));
        System.out.println(readDuration(properties, "b"));
        System.out.println(readDuration(properties, "c"));
        System.out.println(readDuration(properties, "d"));
    }


    private static int readDuration(Properties properties, String key) {

        return Optional.ofNullable(properties.getProperty(key))
                .flatMap(PropertiesExample::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    private static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
