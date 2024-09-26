package domain.banking.usecase;

import domain.banking.entity.accounts.AccountType;
import domain.banking.entity.dto.CreatePersonalAccountUiDTO;
import domain.banking.factory.CheckingAccountFactory;
import domain.banking.factory.SavingAccountFactory;
import domain.banking.service.BankAccountService;
import domain.framework.ui.command.UICommand;
import domain.framework.factory.AccountFactory;

public class CreatePersonalAccountUsecase implements UICommand<CreatePersonalAccountUiDTO> {
    private final BankAccountService bankAccountService;

    public CreatePersonalAccountUsecase(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public void execute(CreatePersonalAccountUiDTO uiCommandData) throws RuntimeException {
        AccountFactory accountFactory = uiCommandData.getAccountType().equals(AccountType.CHECKING) ? new CheckingAccountFactory() : new SavingAccountFactory();
        try {
            bankAccountService.createAccount(uiCommandData.getAccountNumber(), uiCommandData.getCustomer(), accountFactory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
