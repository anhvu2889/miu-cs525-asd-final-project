package domain.framework.usecase.notification.subject;

import domain.framework.usecase.notification.observer.Observer;

public interface Subject {
    void registerObserver(EventType eventType, Observer observer);

    void removeObserver(EventType eventType, Observer observer);

    void triggerEvent(EventType eventType);

    void notifyObservers(EventType eventType);
}
