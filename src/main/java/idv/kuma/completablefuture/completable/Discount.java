package idv.kuma.completablefuture.completable;

import static com.sun.tools.javac.util.Constants.format;
import static idv.kuma.completablefuture.completable.Tools.delay;

public class Discount {

    public enum Code {
        NONE(1),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
                Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static String apply(double price, Code code) {
        delay();
        return format(price * (100 - code.percentage) / 100);
    }


}
