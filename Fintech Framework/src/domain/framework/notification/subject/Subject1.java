package domain.framework.notification.subject;

import domain.framework.entity.TransactionType;
import domain.framework.notification.observer.Observer;

public interface Subject1 {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(TransactionType event, Object object);
}
