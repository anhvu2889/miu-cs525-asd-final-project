package domain.framework.notification.observer;

import domain.framework.entity.Account;
import domain.framework.entity.TransactionType;

public class EmailSender implements Observer {
    private static EmailSender instance = new EmailSender();

    private EmailSender() {
    }

    public static EmailSender getInstance() {
        return EmailSender.instance;
    }

    @Override
    public void onUpdate(TransactionType transactionType, Object object) {
        Account acc = (Account) object;
        System.out.println("[EMAIL]: Event: " + transactionType + ",Account: " + acc.getCustomer().getName() + ", Email: " + acc.getCustomer().getEmail());
    }

    @Override
    public void onUpdate() {

    }
}