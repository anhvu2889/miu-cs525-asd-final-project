package domain.framework.ui.frame;

import domain.framework.entity.Account;

import java.util.List;

public interface FrameConfig<T extends Account> {
    int getFrameHeight();

    int getFrameWidth();

    List<String> getColumnsOfAccountTable();

    int getAccountNumberColumnIndex();

    int getAccountScrollPanelWidth();

    int getAccountScrollPanelHeight();

    int getAccountTableWidth();

    int getAccountTableHeight();

    Object[] buildRow(T account);

    int getCustomerNameColumnIndex();
}
