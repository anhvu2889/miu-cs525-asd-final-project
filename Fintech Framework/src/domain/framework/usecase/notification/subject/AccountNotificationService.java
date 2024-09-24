package domain.framework.usecase.notification.subject;

import domain.framework.usecase.notification.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccountNotificationService implements Subject {
    HashMap<EventType, List<Observer>> observers = new HashMap<EventType, List<Observer>>();

    @Override
    public void registerObserver(EventType eventType, Observer observer) {
        observers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(observer);
    }

    @Override
    public void removeObserver(EventType eventType, Observer observer) {
        List<Observer> listeners = observers.get(eventType);
        if (listeners != null) {
            listeners.remove(observer);
            if (listeners.isEmpty()) {
                observers.remove(eventType);
            }
        }
    }

    @Override
    public void notifyObservers(EventType eventType) {
        List<Observer> listeners = observers.get(eventType);
        if (listeners != null) {
            for (Observer observer : listeners) {
                observer.onUpdate();
            }
        }
    }

    @Override
    public void triggerEvent(EventType eventType) {
        notifyObservers(eventType);
    }

}
