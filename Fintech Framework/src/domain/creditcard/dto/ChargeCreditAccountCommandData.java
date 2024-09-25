package domain.creditcard.dto;

public record ChargeCreditAccountCommandData(String accountNumber, double amount, String description) {
}
