package domain.banking.entity.accounts;

public enum AccountType {
    SAVING("Saving"),
    CHECKING("Checking");

    private final String name;

    AccountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
