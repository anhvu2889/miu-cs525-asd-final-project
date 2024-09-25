package domain.banking.usecase;

import domain.banking.BankService;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.DepositUiDTO;

public class DepositAccountUsecase implements UICommand<DepositUiDTO> {
    private final BankService bankService;

    public DepositAccountUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(DepositUiDTO uiCommandData) throws RuntimeException {
        try {
            bankService.deposit(uiCommandData.getAccountNumber(), uiCommandData.getAmount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
