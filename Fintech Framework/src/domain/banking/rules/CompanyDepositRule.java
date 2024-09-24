package domain.banking.rules;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.Event;
import domain.framework.rules.BankTransactionRule;
import domain.framework.usecase.notification.subject.Subject;

public class CompanyDepositRule implements BankTransactionRule<Account, AccountEntry> {
    private final Subject subject;

    public CompanyDepositRule(Subject notificationSubject) {
        this.subject = notificationSubject;
    }

    @Override
    public boolean matches(Account account, Double amount, String description, Event event) {
        return account.getCustomer().getCustomerType().equals("Company");
    }

    @Override
    public void apply(Account account, Double amount, String description, Event event) {
        this.subject.notifyObservers(event, account);
    }
}
