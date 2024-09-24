package domain.framework.usecase.notification.subject;

import domain.framework.entity.TransactionType;
import domain.framework.usecase.notification.observer.Observer;

public interface Subject1 {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(TransactionType event, Object object);
}
