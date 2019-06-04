package idv.kuma.completablefuture.future;

import java.util.concurrent.*;

public class BasicFuture {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();


        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                Thread.sleep(3000L);
                return 30D;
            }
        });

        System.out.println(50);

        try {
            Double result = future.get(2, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
