package domain.creditcard.dto;

import domain.framework.ui.dto.WithdrawUiDTO;

public class ChargeCreditUiDTO extends WithdrawUiDTO {
    public ChargeCreditUiDTO(String accountNumber, double amount, String description) {
        super(accountNumber, amount, description);
    }
}
