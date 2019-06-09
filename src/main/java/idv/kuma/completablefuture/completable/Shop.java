package idv.kuma.completablefuture.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static idv.kuma.completablefuture.completable.Tools.delay;

public class Shop {

    private final String name;
    private Random random = new Random();

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private Future<Double> getPriceAsync_UsingAnonymousClass(String product) {

        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();

        return futurePrice;
    }

    private Future<Double> getPriceAsync_UsingFactory(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void main(String[] args) {

        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync_UsingFactory("My Favorite Product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000L;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        doSomethingElse();

        try {
            Double price = futurePrice.get(2, TimeUnit.SECONDS);
            System.out.println("Price is " + price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000L;
        System.out.println("Price returned after " + retrievalTime + " msecs");


    }

    private static void doSomethingElse() {
        System.out.println("Doing something else...");
    }

}
