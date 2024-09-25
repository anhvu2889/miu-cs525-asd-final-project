package domain.banking.usecase;

import domain.banking.BankService;
import domain.banking.entity.accounts.AccountType;
import domain.banking.entity.dto.CreateCompanyAccountUIDTO;
import domain.banking.factory.CheckingAccountFactory;
import domain.banking.factory.SavingAccountFactory;
import domain.framework.ui.command.UICommand;
import domain.framework.usecase.management.AccountFactory;

public class CreatecompanyAccountUsecase implements UICommand<CreateCompanyAccountUIDTO> {
    private final BankService bankService;

    public CreatecompanyAccountUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(CreateCompanyAccountUIDTO uiCommandData) throws RuntimeException {
        AccountFactory accountFactory = uiCommandData.getAccountType().equals(AccountType.CHECKING) ? new CheckingAccountFactory() : new SavingAccountFactory();
        try {
            bankService.createAccount(uiCommandData.getAccountNumber(), uiCommandData.getCustomer(), accountFactory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
