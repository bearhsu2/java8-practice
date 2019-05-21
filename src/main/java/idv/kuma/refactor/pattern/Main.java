package idv.kuma.refactor.pattern;

public class Main {

    public static void main(String[] args) {

        // Old fashioned way
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("I really love labda!!!");
        System.out.println(result);

        // Lambda way
    }
}
