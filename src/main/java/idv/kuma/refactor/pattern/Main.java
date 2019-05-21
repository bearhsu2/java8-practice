package idv.kuma.refactor.pattern;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {

        // Old fashioned way
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckProcessing();
        p1.setSuccessor(p2);
        String result1 = p1.handle("I really love labda!!!");
        System.out.println(result1);

        // Lambda way
        UnaryOperator<String> headerProcessing = (String input) -> "From Jack: " + input;
        UnaryOperator<String> spellCheckProcessing = (String input) -> input.replaceAll("labda", "lambda");
        Function<String, String > pipeline =
                headerProcessing.andThen(spellCheckProcessing);
        String result2 = pipeline.apply("I really love labda!!!");
        System.out.println(result2);


    }
}
