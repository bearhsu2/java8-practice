package idv.kuma.completablefuture.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private List<Shop> shops;

    private final Executor executor;

    {

    }

    public Main() {
        this.shops = Arrays.asList(
                new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll")
        );

        executor = Executors.newFixedThreadPool(
                Math.min(shops.size(), 100),
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                }
        );
    }

    public List<String> findPrices(String product) {


        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor)));

    }

    public static void main(String[] args) {

        Main main = new Main();

        long start = System.nanoTime();

        CompletableFuture[] futures = main.findPricesStream("SSSAAA")
                .map(f -> f.thenAccept(
                        s -> System.out.println(s + " ( done in "
                                + (System.nanoTime() - start) / 1_000_000 + " msecs).")))
                .toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in "
                + (System.nanoTime() - start) / 1_000_000 + " msecs.");

//
//        System.out.println(main.findPrices("SSSAAA"));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");

    }
}
