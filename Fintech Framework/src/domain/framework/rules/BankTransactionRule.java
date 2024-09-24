package domain.framework.rules;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.Event;

public interface BankTransactionRule<E extends Account, T extends AccountEntry> extends Rule<E, T> {
    default public boolean matches(E account, T entry) {
        return matches(account, entry.getAmount(), entry.getDescription(), entry.getEvent());
    }

    default public void apply(E bankAccount, T entry) {
        apply(bankAccount, entry.getAmount(), entry.getDescription(), entry.getEvent());
    }

    public boolean matches(E bankAccount, Double amount, String description, Event event);


    public void apply(E bankAccount, Double amount, String description, Event event);
}
