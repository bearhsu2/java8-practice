package idv.kuma.lambda;

import java.util.Comparator;
import java.util.List;

/**
 * Created by bearhsu2 on 4/13/2018.
 */
public class LambdaBasics {

    public void doComparePractice(List<Apple> appleList){

        Comparator<Apple> comparatorOld = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        Comparator<Apple> comparatorLambda = (Apple o1, Apple o2) -> o1.getWeight() - o2.getWeight();

    }

    public void runnableExample(){



        Thread t = new Thread(() -> System.out.println("aa"));
        t.start();
    }

}
