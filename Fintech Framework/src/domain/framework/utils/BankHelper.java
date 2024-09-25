package domain.framework.utils;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.rules.RuleEngine;

public class BankHelper {

    public static RuleEngine<Account, AccountEntry> getRuleEngine() {
        return new RuleEngine<>();
    }

}
