package domain.framework.usecase.operation;

public interface AccountOperationService<E, T> {
    void deposit(E e, T t);

    void withdraw(E e, T t);

    void addInterest();
}
