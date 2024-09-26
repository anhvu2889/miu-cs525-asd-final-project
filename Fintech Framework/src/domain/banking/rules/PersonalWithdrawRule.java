package domain.banking.rules;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.TransactionType;
import domain.framework.rules.BankTransactionRule;
import domain.framework.notification.subject.Subject;

public class PersonalWithdrawRule implements BankTransactionRule<Account, AccountEntry> {
    private final Subject subject;

    public PersonalWithdrawRule(Subject notificationSubject) {
        this.subject = notificationSubject;
    }

    @Override
    public boolean matches(Account account, Double amount, String description, TransactionType transactionType) {
        return account.getCustomer().getCustomerType().equals("Person") && account.getBalance() < amount;
    }

    @Override
    public void apply(Account account, Double amount, String description, TransactionType transactionType) {
        this.subject.notifyObservers(transactionType, account);
    }
}
