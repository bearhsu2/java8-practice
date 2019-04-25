package idv.kuma.lambda;

public class LocalVariablesInLambda {

    public static void main(String[] args) {
        int port = 12345;
        Runnable r = () -> System.out.println(port);

        // You cannot assign value to port twice. port should be physically final!!!
        // port = 222;

        r.run();
    }
}
