package domain.banking.ui;

import domain.banking.entity.accounts.CheckingAccount;
import domain.banking.entity.customers.Company;
import domain.framework.entity.Account;
import domain.framework.ui.frame.FrameConfig;

import java.util.ArrayList;
import java.util.List;

public class BankFrameConfig implements FrameConfig<Account> {
    @Override
    public int getFrameHeight() {
        return 330;
    }

    @Override
    public int getFrameWidth() {
        return 690;
    }

    @Override
    public List<String> getColumnsOfAccountTable() {
        List<String> columns = new ArrayList<>();
        columns.add("AccountNr");
        columns.add("Name");
        columns.add("City");
        columns.add("P/C");
        columns.add("Ch/S");
        columns.add("Amount");
        return columns;
    }

    @Override
    public Object[] buildRow(Account account) {
        Object[] rowdata = new Object[6];
        rowdata[0] = account.getNumber();
        rowdata[1] = account.getCustomer().getName();
        rowdata[2] = account.getCustomer().getAddress().getCity();
        rowdata[3] = account.getCustomer() instanceof Company ? "C" : "P";
        rowdata[4] = account instanceof CheckingAccount ? "Ch" : "S";
        rowdata[5] = account.getBalance();
        return rowdata;
    }

    @Override
    public int getCustomerNameColumnIndex() {
        return 1;
    }

    @Override
    public int getAccountNumberColumnIndex() {
        return 0;
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


}
