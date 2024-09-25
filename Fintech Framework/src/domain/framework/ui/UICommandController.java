package domain.framework.ui;

import domain.framework.ui.command.UICommand;

public interface UICommandController<T> {
    void setFrameUpdateCommand(UICommand<T> frameUpdateCommand);

    void setDepositCommand(UICommand<T> depositUICommand);

    void setWithdrawCommand(UICommand<T> withdrawUICommand);
}
