package domain.framework.rules;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.TransactionType;

public interface BankTransactionRule<E extends Account, T extends AccountEntry> extends Rule<E, T> {
    default boolean matches(E account, T entry) {
        return matches(account, entry.getAmount(), entry.getDescription(), entry.getTransactionType());
    }

    default void apply(E account, T entry) {
        apply(account, entry.getAmount(), entry.getDescription(), entry.getTransactionType());
    }

    boolean matches(E account, Double amount, String description, TransactionType transactionType);


    void apply(E account, Double amount, String description, TransactionType transactionType);
}
