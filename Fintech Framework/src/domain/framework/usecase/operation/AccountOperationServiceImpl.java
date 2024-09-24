package domain.framework.usecase.operation;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.rules.RuleEngine;
import domain.framework.usecase.notification.observer.Observer;
import domain.framework.usecase.notification.subject.Subject;
import driver.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountOperationServiceImpl<E extends Account, T extends AccountEntry> implements AccountOperationService<E, T> {

    private final AccountRepository repository;
    private final RuleEngine<E, T> ruleEngine;
    private final Subject notificationSubject;

    public AccountOperationServiceImpl(AccountRepository accountRepository, RuleEngine<E, T> ruleEngine, Subject notificationSubject) {
        this.ruleEngine = ruleEngine;
        this.repository = accountRepository;
        this.notificationSubject = notificationSubject;
    }

    public AccountRepository getRepository() {
        return repository;
    }

    public RuleEngine<E, T> getRuleEngine() {
        return ruleEngine;
    }

    public Subject getNotificationSubject() {
        return notificationSubject;
    }

    @Override
    public void deposit(E e, T t) {
        try {
            this.ruleEngine.process(e, t);
            e.deposit(t.getAmount(), t.getDescription());
            this.repository.update(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void withdraw(E e, T t) {
        try {
            this.ruleEngine.process(e, t);
            e.withdraw(t.getAmount(), t.getDescription());
            this.repository.update(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addInterest() {
        for (Account account : this.repository.getAllAccounts()) {
            account.addInterest();
            this.repository.update(account);
        }
    }
}
