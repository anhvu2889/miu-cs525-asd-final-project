package domain.framework.usecase;

import domain.framework.entity.Account;

public interface AccountManagementUsecase {
    Account createAccount(String number);
}
