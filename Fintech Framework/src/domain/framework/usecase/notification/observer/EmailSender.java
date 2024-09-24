package domain.framework.usecase.notification.observer;

import domain.framework.entity.Account;
import domain.framework.entity.Event;

public class EmailSender implements Observer {
    private static EmailSender instance = new EmailSender();

    private EmailSender() {
    }

    public static EmailSender getInstance() {
        return EmailSender.instance;
    }

    @Override
    public void onUpdate(Event event, Object object) {
        Account acc = (Account) object;
        System.out.println("[EMAIL]: Event: " + event + ",Account: " + acc.getCustomer().getCustomerType() + ", Email: " + acc.getCustomer().getEmail());
    }
}