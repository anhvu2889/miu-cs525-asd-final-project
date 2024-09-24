package domain.banking.usecase;

import domain.banking.BankService;
import domain.banking.entity.BankUiCommandData;
import domain.banking.entity.accounts.AccountType;
import domain.banking.factory.CheckingAccountFactory;
import domain.banking.factory.SavingAccountFactory;
import domain.framework.ui.command.UICommand;
import domain.framework.usecase.management.AccountFactory;

public class CreateAccountUsecase implements UICommand<BankUiCommandData> {
    private final BankService bankService;

    public CreateAccountUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(BankUiCommandData uiCommandData) throws RuntimeException {
        AccountFactory accountFactory = uiCommandData.accountType().equals(AccountType.CHECKING) ? new CheckingAccountFactory() : new SavingAccountFactory();
        try {
            bankService.createAccount(uiCommandData.accountNumber(), uiCommandData.customer(), accountFactory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
