package domain.framework.usecase.management;

import domain.framework.entity.Account;
import domain.framework.entity.Customer;

public interface AccountManagementService {
     Account createAccount(String accountNumber, Customer customer);
}
