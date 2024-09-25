package domain.banking.usecase;

import domain.banking.service.BankAccountService;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.WithdrawUiDTO;

public class WithdrawAccountUsecase implements UICommand<WithdrawUiDTO> {
    private final BankAccountService bankAccountService;

    public WithdrawAccountUsecase(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public void execute(WithdrawUiDTO uiCommandData) throws RuntimeException {
        try {
            bankAccountService.withdraw(uiCommandData.getAccountNumber(), uiCommandData.getAmount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}