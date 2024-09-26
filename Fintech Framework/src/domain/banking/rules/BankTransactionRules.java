package domain.banking.rules;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.rules.Rule;
import domain.framework.notification.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class BankTransactionRules {
    public static List<Rule<Account, AccountEntry>> getDepositRules(Subject notificationSubject) {
        List<Rule<Account, AccountEntry>> rules = new ArrayList<>();
        rules.add(new CompanyDepositRule(notificationSubject));
        rules.add(new PersonalDepositRule(notificationSubject));
        return rules;
    }
    public static List<Rule<Account, AccountEntry>> getWithdrawRules(Subject notificationSubject) {
        List<Rule<Account, AccountEntry>> rules = new ArrayList<>();
        rules.add(new CompanyWithdrawRule(notificationSubject));
        rules.add(new PersonalWithdrawRule(notificationSubject));
        return rules;
    }
}
