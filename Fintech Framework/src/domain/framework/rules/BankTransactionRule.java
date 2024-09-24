package domain.framework.rules;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.TransactionType;

public interface BankTransactionRule<E extends Account, T extends AccountEntry> extends Rule<E, T> {
    default public boolean matches(E account, T entry) {
        return matches(account, entry.getAmount(), entry.getDescription(), entry.getTransactionType());
    }

    default public void apply(E bankAccount, T entry) {
        apply(bankAccount, entry.getAmount(), entry.getDescription(), entry.getTransactionType());
    }

    public boolean matches(E bankAccount, Double amount, String description, TransactionType event);


    public void apply(E bankAccount, Double amount, String description, TransactionType event);
}
