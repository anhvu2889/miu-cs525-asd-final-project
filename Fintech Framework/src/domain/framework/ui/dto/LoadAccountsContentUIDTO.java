package domain.framework.ui.dto;

import domain.framework.entity.Account;

import java.util.Collection;

public class LoadAccountsContentUIDTO {
    private Collection<Account> accounts;

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
}
