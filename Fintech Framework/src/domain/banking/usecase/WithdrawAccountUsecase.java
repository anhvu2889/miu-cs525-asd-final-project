package domain.banking.usecase;

import domain.banking.BankService;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.WithdrawUiDTO;

public class WithdrawAccountUsecase implements UICommand<WithdrawUiDTO> {
    private final BankService bankService;

    public WithdrawAccountUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(WithdrawUiDTO uiCommandData) throws RuntimeException {
        try {
            bankService.withdraw(uiCommandData.getAccountNumber(), uiCommandData.getAmount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}