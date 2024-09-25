package domain.banking.usecase;

import domain.banking.service.BankAccountService;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.DepositUiDTO;

public class DepositAccountUsecase implements UICommand<DepositUiDTO> {
    private final BankAccountService bankAccountService;

    public DepositAccountUsecase(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public void execute(DepositUiDTO uiCommandData) throws RuntimeException {
        try {
            bankAccountService.deposit(uiCommandData.getAccountNumber(), uiCommandData.getAmount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
