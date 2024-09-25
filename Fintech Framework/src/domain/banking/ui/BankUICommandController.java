package domain.banking.ui;

import domain.framework.ui.UICommandController;
import domain.framework.ui.command.UICommand;

public interface BankUICommandController<T> extends UICommandController<T> {
    void setAddPersonalAccountCommand(UICommand<T> addAccountCommand);

    void setAddCompanyAccountCommand(UICommand<T> addAccountCommand);

    void setAddInterestCommand(UICommand<T> addInterestCommand);

    void setAllAccReportCommand(UICommand<T> allAccReportCommand);
}
