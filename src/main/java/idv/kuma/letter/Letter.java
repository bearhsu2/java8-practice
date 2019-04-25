package idv.kuma.letter;

import java.util.function.Function;

public class Letter {

    public static String addHeader(String text) {
        return "Header: " + text;
    }

    public static String addFooter(String text) {
        return text + " ||| Footer";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transform = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        String result = transform.apply("my labda ohoh");
        System.out.println(result);

    }
}
