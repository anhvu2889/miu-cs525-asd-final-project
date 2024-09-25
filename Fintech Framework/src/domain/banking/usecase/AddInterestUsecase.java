package domain.banking.usecase;

import domain.banking.BankService;
import domain.banking.entity.dto.AddInterestUiDTO;
import domain.framework.ui.command.UICommand;

public class AddInterestUsecase implements UICommand<AddInterestUiDTO> {
    private final BankService bankService;

    public AddInterestUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(AddInterestUiDTO uiCommandData) {
        bankService.addInterest();
    }
}
