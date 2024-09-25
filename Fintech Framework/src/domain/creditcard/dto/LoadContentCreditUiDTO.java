package domain.creditcard.dto;

import domain.framework.entity.Account;

import java.util.Collection;

public class LoadContentCreditUiDTO {
    private Collection<Account> accounts;

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
}
