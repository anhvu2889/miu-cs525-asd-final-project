package domain.creditcard.dto;

public record DepositCreditAccountCommandData(String accountNumber, double amount, String description) {
}
