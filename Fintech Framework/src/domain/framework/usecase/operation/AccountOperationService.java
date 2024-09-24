package domain.framework.usecase.operation;

public interface AccountOperationService {
    void deposit (double amount);
    void withdraw (double amount);
    void addInterest();
}
