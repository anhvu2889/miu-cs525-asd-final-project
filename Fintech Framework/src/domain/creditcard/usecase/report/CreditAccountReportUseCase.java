package domain.creditcard.usecase.report;

import domain.creditcard.CreditCardService;
import domain.creditcard.entity.CreditAccountReport;

public class CreditAccountReportUseCase {

    private final CreditCardService creditCardService;

    public CreditAccountReportUseCase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    public CreditAccountReport execute(String accountNumber) throws RuntimeException {
        try {
            return creditCardService.generateMonthlyReport(accountNumber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
