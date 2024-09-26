package domain.framework.notification.subject;

import domain.framework.entity.TransactionType;
import domain.framework.notification.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NotifySubject implements Subject1 {
    protected List<Observer> observerList = new ArrayList<>();

    public List<Observer> getObserverList() {
        return this.observerList;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers(TransactionType transactionType, Object object) {
        for (Observer observer : this.observerList) {
            observer.onUpdate(transactionType, object);
        }
    }
}