package domain.creditcard.ui;

import domain.creditcard.entity.CreditAccount;
import domain.framework.ui.frame.FrameConfig;

import java.util.ArrayList;
import java.util.List;

public class CreditCardFrameConfig implements FrameConfig<CreditAccount> {
    @Override
    public int getFrameHeight() {
        return 310;
    }

    @Override
    public int getFrameWidth() {
        return 575;
    }

    @Override
    public List<String> getColumnsOfAccountTable() {
        List<String> columns = new ArrayList<>();
        columns.add("Name");
        columns.add("CC Number");
        columns.add("Exp Date");
        columns.add("Type");
        columns.add("Balance");
        return columns;
    }

    @Override
    public int getAccountNumberColumnIndex() {
        return 1;
    }

    @Override
    public int getAccountScrollPanelWidth() {
        return 444;
    }

    @Override
    public int getAccountScrollPanelHeight() {
        return 160;
    }

    @Override
    public int getAccountTableWidth() {
        return 420;
    }

    @Override
    public int getAccountTableHeight() {
        return 0;
    }

    @Override
    public Object[] buildRow(CreditAccount account) {
        Object[] rowdata = new Object[5];
        rowdata[0] = account.getCustomer().getName();
        rowdata[1] = account.getNumber();
        rowdata[2] = account.getExprDate();
        rowdata[3] = account.getAccountType().getName();
        rowdata[4] = account.getBalance() != 0 ? account.getBalance() * -1 : account.getBalance();
        return rowdata;
    }

    @Override
    public int getCustomerNameColumnIndex() {
        return 0;
    }
}
