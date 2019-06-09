package idv.kuma.completablefuture.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    private List<Shop> shops;

    public Main() {
        this.shops = Arrays.asList(
                new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavofiteShop"),
                new Shop("ButItAll")
        );
    }

    public List<String> findPrices(String product) {

        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " + shop.getPrice(product)))
                .collect(Collectors.toList());


        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());


    }

    public static void main(String[] args) {

        Main main = new Main();

        long start = System.nanoTime();
        System.out.println(main.findPrices("SSSAAA"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");

    }
}
