package idv.kuma.functional;

import java.util.function.DoubleUnaryOperator;

public class UnaryTry {

    private static DoubleUnaryOperator makeConverter(double a, double b) {
        return x -> x * a + b;
    }


    public static void main(String[] args) {
        DoubleUnaryOperator convertCtoF = makeConverter(9D / 5, 32);
        System.out.println(convertCtoF.applyAsDouble(30D));


        DoubleUnaryOperator convertUSDtoGBP = makeConverter(0.6, 0);
        System.out.println(convertUSDtoGBP.applyAsDouble(300));
    }


}
