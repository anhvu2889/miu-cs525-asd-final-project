package domain.banking.usecase;

import domain.banking.BankService;
import domain.banking.entity.BankUiCommandData;
import domain.framework.ui.command.UICommand;

public class DepositAccountUsecase implements UICommand<BankUiCommandData> {
    private final BankService bankService;

    public DepositAccountUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(BankUiCommandData uiCommandData) throws RuntimeException {
        try {
            bankService.deposit(uiCommandData.accountNumber(), uiCommandData.amount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
