package dsa.Week2.day3;

import java.math.BigDecimal;

public class Account {

    private final String pin;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(String pin) {
        this.pin = pin;
    }

    public void deposit(BigDecimal amount, String pin) {
        validatePin(pin);
        validateAmount(amount);

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount, String pin) {
        validatePin(pin);
        validateAmount(amount);

        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        balance = balance.subtract(amount);
    }

    public BigDecimal checkBalance(String pin) {
        validatePin(pin);
        return balance;
    }

    // 🔐 PIN validation
    private void validatePin(String pin) {
        if (!this.pin.equals(pin)) {
            throw new IllegalArgumentException("Invalid PIN");
        }
    }

    // 💰 Amount validation (THIS FIXES YOUR FAILING TESTS)
    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}