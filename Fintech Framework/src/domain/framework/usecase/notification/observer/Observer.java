package domain.framework.usecase.notification.observer;

import domain.framework.entity.TransactionType;

public interface Observer {
    void onUpdate(TransactionType transactionType, Object object);
    void onUpdate();
}
