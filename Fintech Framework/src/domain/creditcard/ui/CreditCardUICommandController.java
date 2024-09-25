package domain.creditcard.ui;

import domain.framework.ui.UICommandController;
import domain.framework.ui.command.UICommand;

public interface CreditCardUICommandController<T> extends UICommandController<T> {
    void setAddCreditCardAccountCommand(UICommand<T> addCreditCardAccountCommand);

    void setChargeCreditCardCommand(UICommand<T> chargeCreditCardCommand);

    void setBillReportCommand(UICommand<T> billReportCommand);
}
