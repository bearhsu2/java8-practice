package idv.kuma.refactor.subjectobserver.subject;

import idv.kuma.refactor.subjectobserver.observer.Observer;

public interface Subject {
    void registerObserver(Observer o);

    void notifyObservers(String tweet);
}
