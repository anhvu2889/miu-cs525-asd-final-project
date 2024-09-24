package domain.framework.usecase.notification.subject;

import domain.framework.entity.Event;
import domain.framework.usecase.notification.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Event event, Object object);
}
