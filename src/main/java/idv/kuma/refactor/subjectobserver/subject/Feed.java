package idv.kuma.refactor.subjectobserver.subject;

import idv.kuma.refactor.subjectobserver.observer.Observer;
import idv.kuma.refactor.subjectobserver.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));

    }
}
