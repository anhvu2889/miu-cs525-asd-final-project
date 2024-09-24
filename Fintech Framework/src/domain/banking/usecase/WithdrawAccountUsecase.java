package domain.banking.usecase;

import domain.banking.BankService;
import domain.banking.entity.BankUiCommandData;
import domain.framework.ui.command.UICommand;

public class WithdrawAccountUsecase implements UICommand<BankUiCommandData> {
    private final BankService bankService;

    public WithdrawAccountUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(BankUiCommandData uiCommandData) throws RuntimeException {
        try {
            bankService.withdraw(uiCommandData.accountNumber(), uiCommandData.amount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}