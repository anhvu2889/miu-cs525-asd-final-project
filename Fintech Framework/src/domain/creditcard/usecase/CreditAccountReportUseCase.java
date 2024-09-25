package domain.creditcard.usecase;

import domain.creditcard.CreditCardService;
import domain.creditcard.dto.BillReportUiDTO;
import domain.framework.ui.command.UICommand;

public class CreditAccountReportUseCase implements UICommand<BillReportUiDTO> {

    private final CreditCardService creditCardService;

    public CreditAccountReportUseCase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    public void execute(BillReportUiDTO billReportUiDTO) throws RuntimeException {
        try {
            creditCardService.generateMonthlyReport(billReportUiDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
