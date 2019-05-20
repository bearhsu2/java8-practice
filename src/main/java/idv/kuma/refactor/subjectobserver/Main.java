package idv.kuma.refactor.subjectobserver;

import idv.kuma.refactor.subjectobserver.observer.Guardian;
import idv.kuma.refactor.subjectobserver.observer.LeMonde;
import idv.kuma.refactor.subjectobserver.observer.NYTimes;
import idv.kuma.refactor.subjectobserver.subject.Feed;

public class Main {

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.notifyObservers("The queen said her favorite book is Java 8 in Action!");
    }
}
