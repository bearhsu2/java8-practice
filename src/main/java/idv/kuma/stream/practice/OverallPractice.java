package idv.kuma.stream.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OverallPractice {

    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario", "Milan");
    private static Trader alan = new Trader("Alan", "Cambridge");
    private static Trader brian = new Trader("Brian", "Cambridge");

    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1001),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {

        // 1) find 2011 transactions and sort by value
        List<Transaction> sorted = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(sorted);

        // 2) find all different cities where traders had been worked
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        // 3) check all traders from Cambridge, sorted by name
        List<Trader> cambridgeTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equalsIgnoreCase("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(cambridgeTraders);

        // 4) find all trader names, sorted by name
        String allTraderNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(allTraderNames);

        // 5) Is there any traders working in Milan?
        boolean anyMatch = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan"));
        System.out.println(anyMatch);

        // 6) Print out all trade values of traders in Milan
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Milan"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 7) what is the largest transaction value
        Optional<Integer> largest = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        System.out.println(largest.get());

        // 8) find the transaction with the smallest value
        Optional<Transaction> smallest = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(smallest.get());


    }
}
