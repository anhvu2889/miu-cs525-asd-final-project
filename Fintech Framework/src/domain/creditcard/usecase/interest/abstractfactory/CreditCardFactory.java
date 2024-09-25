package domain.creditcard.usecase.interest.abstractfactory;

import domain.creditcard.entity.CreditAccount;
import domain.creditcard.entity.CreditCardType;
import domain.creditcard.dto.NewCreditAccountCommandData;
import domain.creditcard.usecase.interest.miniumpayment.BronzeMinimumPaymentCalculatorStrategy;
import domain.creditcard.usecase.interest.miniumpayment.GoldMinimumPaymentCalculatorStrategy;
import domain.creditcard.usecase.interest.miniumpayment.SilverMinimumPaymentCalculatorStrategy;
import domain.creditcard.usecase.interest.monthlyinterest.BronzeMonthlyInterestCalculatorStrategy;
import domain.creditcard.usecase.interest.monthlyinterest.GoldMonthlyInterestCalculatorStrategy;
import domain.creditcard.usecase.interest.monthlyinterest.SilverMonthlyInterestCalculatorStrategy;
import domain.framework.entity.Account;
import domain.framework.entity.Customer;
import domain.framework.usecase.management.AccountFactory;

public class CreditCardFactory implements AccountFactory {
    NewCreditAccountCommandData newCreditAccountCommandData;

    public CreditCardFactory(NewCreditAccountCommandData newCreditAccountCommandData) {
        this.newCreditAccountCommandData = newCreditAccountCommandData;
    }

    public Account createCreditAccount() {
        CreditAccount account = new CreditAccount(
                newCreditAccountCommandData.accountNumber(),
                newCreditAccountCommandData.customer(),
                newCreditAccountCommandData.expiredDate(),
                newCreditAccountCommandData.creditCardType()
        );
        CreditCardType creditCardType = newCreditAccountCommandData.creditCardType();
        switch (creditCardType) {
            case GOLD: {
                account.setInterestCalculator(new GoldMonthlyInterestCalculatorStrategy(creditCardType.getMonthlyInterestRate()));
                account.setMinimumPaymentStrategy(new GoldMinimumPaymentCalculatorStrategy(creditCardType.getMinimumPaymentRate()));
                break;
            }
            case SILVER: {
                account.setInterestCalculator(new SilverMonthlyInterestCalculatorStrategy(creditCardType.getMonthlyInterestRate()));
                account.setMinimumPaymentStrategy(new SilverMinimumPaymentCalculatorStrategy(creditCardType.getMinimumPaymentRate()));
                break;
            }
            case BRONZE: {
                account.setInterestCalculator(new BronzeMonthlyInterestCalculatorStrategy(creditCardType.getMonthlyInterestRate()));
                account.setMinimumPaymentStrategy(new BronzeMinimumPaymentCalculatorStrategy(creditCardType.getMinimumPaymentRate()));
                break;
            }
        }

        return account;
    }

    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        return null;
    }

    public String getAccountNumber() {
        return newCreditAccountCommandData.accountNumber();
    }
}