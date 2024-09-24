package domain.framework.utils;

import domain.banking.rules.CompanyDepositRule;
import domain.banking.rules.PersonalDepositRule;
import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.rules.Rule;
import domain.framework.rules.RuleEngine;
import domain.framework.usecase.notification.observer.EmailSender;
import domain.framework.usecase.notification.observer.Observer;
import domain.framework.usecase.notification.subject.Subject;
import domain.framework.usecase.notification.subject.Subject1;

import java.util.ArrayList;
import java.util.List;

public class BankHelper {

    public static RuleEngine<Account, AccountEntry> getRuleEngine() {
        return new RuleEngine<>();
    }

    public static List<Rule<Account, AccountEntry>> getDepositOrWithdrawRules(Subject1 notificationSubject) {
        List<Observer> observers = new ArrayList<>();
        observers.add(EmailSender.getInstance());
        for (Observer observer : observers) {
            notificationSubject.registerObserver(observer);
        }
        List<Rule<Account, AccountEntry>> rules = new ArrayList<>();
        rules.add(new CompanyDepositRule(notificationSubject));
        rules.add(new PersonalDepositRule(notificationSubject));
        return rules;
    }

}
