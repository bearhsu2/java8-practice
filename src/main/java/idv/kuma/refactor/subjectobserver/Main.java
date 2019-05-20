package idv.kuma.refactor.subjectobserver;

import idv.kuma.refactor.subjectobserver.observer.Guardian;
import idv.kuma.refactor.subjectobserver.observer.LeMonde;
import idv.kuma.refactor.subjectobserver.observer.NYTimes;
import idv.kuma.refactor.subjectobserver.subject.Feed;

public class Main {

    public static void main(String[] args) {

        // The Old Fashioned Way
        Feed f1 = new Feed();
        f1.registerObserver(new NYTimes());
        f1.registerObserver(new Guardian());
        f1.registerObserver(new LeMonde());

        f1.notifyObservers("The queen said her favorite book is Java 8 in Action!");

        // The Lambda Way
        Feed f2 = new Feed();
        f2.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        f2.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });
        f2.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        });
        f2.notifyObservers("The queen said her favorite book is Java 8 in Action!");

    }
}
